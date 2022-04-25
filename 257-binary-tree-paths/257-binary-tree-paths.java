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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        rootToTree(root, "" + Integer.toString(root.val), ans);
        return ans;
    }
    
     public void rootToTree(TreeNode root, String currentPath, List<String> ans) {
        
        if(root.left == null && root.right == null){
            ans.add(currentPath);
            return;
        }
        
        if(root.left != null)
            rootToTree(root.left, currentPath + "->" + Integer.toString(root.left.val), ans);
        
        if(root.right != null)
            rootToTree(root.right, currentPath + "->" + Integer.toString(root.right.val), ans);
    }
}