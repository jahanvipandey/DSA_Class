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
class Pair {
    TreeNode node;
    boolean flag;
    
    Pair(TreeNode node, boolean flag){
        this.node = node;
        this.flag = flag;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }
    
    private int sum(TreeNode root, boolean ifLeft) {
        Queue<Pair> queue = new LinkedList<>();
        int tempAns = 0;
        
        if(root == null)
            return tempAns;
        
        queue.add(new Pair(root, false));
        
        while(!queue.isEmpty()){
            Pair currentObj = queue.remove();
            TreeNode currentNode = currentObj.node;
            boolean currentFlag = currentObj.flag;
            
            if(currentFlag == true && currentNode.left == null && currentNode.right == null)
                tempAns += currentNode.val;
            
            if(currentNode.left != null)
                queue.add(new Pair(currentNode.left, true));
            
            if(currentNode.right != null)
                queue.add(new Pair(currentNode.right, false));
        }
        return tempAns;
    }
}