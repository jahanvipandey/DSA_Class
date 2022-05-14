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
            
        while(!queue.isEmpty()){ //3 9|20 15|7
            
            int levelSize = queue.size(); //1 2 
            count += 1; //1 2 
            
            while(levelSize > 0){ //1 2 2
                TreeNode currentNode = queue.remove(); //3 9 20 15 7
                
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                
                levelSize -= 1; //1 0 1 0
            }
        }
        return count;
    }
}