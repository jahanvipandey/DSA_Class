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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> answer = new ArrayList<>();
        
        if(root == null)
            return answer;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            double sum = 0;
            int size = levelsize;
            //List<Double> level = new ArrayList<>();
            
            while(levelsize > 0) {
                TreeNode currentNode = queue.remove();
                sum += currentNode.val;
                
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                
                levelsize -= 1;
            }
            answer.add(sum/size);
        }
        return answer;
    }
}