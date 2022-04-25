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
    public int sumRootToLeaf(TreeNode root) {
        int[] ans = {0};
        rootToTree(root, Integer.toString(root.val), ans);
        return ans[0];
    }
        
    public void rootToTree(TreeNode root, String currentPath, int[] ans) {
        
        if(root.left == null && root.right == null){
            ans[0] += Integer.parseInt(currentPath, 2);
            return;
        }
        
        if(root.left != null)
            rootToTree(root.left, currentPath + Integer.toString(root.left.val), ans);
        
        if(root.right != null)
            rootToTree(root.right, currentPath + Integer.toString(root.right.val), ans);
    }
}