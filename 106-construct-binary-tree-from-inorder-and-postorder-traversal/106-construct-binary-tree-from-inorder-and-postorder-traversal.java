/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = {postorder.length-1};
        HashMap<Integer, Integer> inIndex = inorderPut(inorder);
        return construct(postorder, inorder, postIndex, inIndex, 0, inorder.length-1);
    }
    
    private TreeNode construct(int[] postorder, int[] inorder, int[] postIndex, HashMap<Integer, Integer> inIndex, int start, int end){
        
        if(start > end || postIndex[0] < 0)
            return null;
        
        int currentVal = postorder[postIndex[0]];
        TreeNode currentNode = new TreeNode(currentVal);
        postIndex[0] -= 1;
        
        int i = inIndex.get(currentVal);
        
        currentNode.right = construct(postorder, inorder, postIndex, inIndex, i+1, end);
        currentNode.left = construct(postorder, inorder, postIndex, inIndex, start, i-1);
        
        return currentNode;
    }
    
    private HashMap<Integer, Integer> inorderPut(int[] inorder) {
        HashMap<Integer, Integer> inIndex = new HashMap<>();
    
        for(int i = 0; i < inorder.length; i++)
            inIndex.put(inorder[i], i);
        
        return inIndex;
    }
}