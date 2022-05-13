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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = {0};
        HashMap<Integer, Integer> inIndex = inorderPut(inorder);
        return construct(preorder, inorder, preIndex, inIndex, 0, inorder.length-1);
    }
    
    private TreeNode construct(int[] preorder, int[] inorder, int[] preIndex, HashMap<Integer, Integer> inIndex, int start, int end){
        
        if(start > end || preIndex[0] >= inorder.length)
            return null;
        
        int currentVal = preorder[preIndex[0]];
        TreeNode currentNode = new TreeNode(currentVal);
        preIndex[0] += 1;
        
        int i = inIndex.get(currentVal);
        
        currentNode.left = construct(preorder, inorder, preIndex, inIndex, start, i-1);
        currentNode.right = construct(preorder, inorder, preIndex, inIndex, i+1, end);
        
        return currentNode;
    }
    
    private HashMap<Integer, Integer> inorderPut(int[] inorder) {
        HashMap<Integer, Integer> inIndex = new HashMap<>();
    
        for(int i = 0; i < inorder.length; i++)
            inIndex.put(inorder[i], i);
        
        return inIndex;
    }
}