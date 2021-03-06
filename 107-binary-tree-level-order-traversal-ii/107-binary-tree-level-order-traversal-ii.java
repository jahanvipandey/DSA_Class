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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
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
        Collections.reverse(answer);
        return answer;
    }
}