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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();

        paths(root, targetSum, new ArrayList<>(), answer);
        
        return answer;
    }
    
    private void paths(TreeNode root, int target, List<Integer> current, List<List<Integer>> answer) {
        
        if(root == null)
            return;
        
        current.add(root.val);
        
        if(root.val == target && root.left == null && root.right == null){
            answer.add(current);
            return;
        }
        
        paths(root.left, target - root.val, new ArrayList<>(current), answer);
        paths(root.right, target - root.val, new ArrayList<>(current), answer);
    }
}