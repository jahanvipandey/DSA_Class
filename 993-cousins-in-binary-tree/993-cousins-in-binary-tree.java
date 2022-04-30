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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parents = new int[2];
        int[] levels = new int[2];
        
        find(root, new TreeNode(-1), 0, x, y, parents, levels);
        return parents[0] != parents[1] && levels[0] == levels[1];
    }
    
    private void find(TreeNode root, TreeNode currentParent, int currentLevel, int x, int y, int[] parents, int[] levels){
        
        if(root == null)
            return;
        
        if(root.val == x){
            parents[0] = currentParent.val;
            levels[0] = currentLevel;
        }
        if(root.val == y){
            parents[1] = currentParent.val;
            levels[1] = currentLevel;
        }
        
        find(root.left, root, currentLevel+1, x, y, parents, levels);
        find(root.right, root, currentLevel+1, x, y, parents, levels);
        
        return;
    }
}