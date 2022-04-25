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
    public int sumOfLeftLeaves(TreeNode root) {
        return leftSum(root, false);
    }
    
    private int leftSum(TreeNode root, Boolean oneLeaf) {
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null) {
            if(oneLeaf)
                return root.val;
            else
                return 0;
        }
        
        int leftans = leftSum(root.left, true);
        int rightans = leftSum(root.right, false);
        
        return leftans + rightans;
    }
}