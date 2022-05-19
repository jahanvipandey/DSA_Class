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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return pathSum(root, targetSum, sum);
    }
    
    private boolean pathSum(TreeNode root, int target, int sum) {
        
        if(root == null)
            return false;
        
        sum += root.val;
        
        if(sum == target && root.left == null && root.right == null)
            return true;
        
        boolean ans1 = pathSum(root.left, target, sum);
        boolean ans2 = pathSum(root.right, target, sum);
        
        return ans1 || ans2;
    }
}