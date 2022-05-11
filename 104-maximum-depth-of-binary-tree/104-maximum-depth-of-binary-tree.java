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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        
        if(root == null)
            return count;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            
            while(queueSize > 0){
                TreeNode currentNode = queue.remove();
               
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                
                queueSize -= 1;
            }
            count += 1;
        }
        return count;
    }
}