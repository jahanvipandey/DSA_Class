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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root == null)
            return answer;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            
            List<Integer> level = new ArrayList<>();
            
            while(queueSize > 0){
                TreeNode currentNode = queue.remove();
                level.add(currentNode.val);
                
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                
                queueSize -= 1;
            }
            
            answer.add(level);
        }
        
        return answer;
    }
}