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
        return sumRoot(root , 0);
    }
    
    private int sumRoot(TreeNode root, int totalSum){
        
        if(root == null)
            return 0;
        
        totalSum = totalSum * 2 + root.val;
        
        if(root.left == null && root.right == null)
            return totalSum;
        
        int leftSum = sumRoot(root.left, totalSum);
        int rightSum = sumRoot(root.right, totalSum);
        
        return leftSum + rightSum;
     }
}