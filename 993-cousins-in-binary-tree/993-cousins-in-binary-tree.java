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
    TreeNode parent;
    
    Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        
        TreeNode parentOfx = null;
        TreeNode parentOfy = null;
        
        queue.add(new Pair(root, new TreeNode(-1)));
    
        while(!queue.isEmpty()){
            
            int currentSize = queue.size();
            
            for(int i = 0; i < currentSize; i++){
                
                Pair currentObj = queue.remove();
                TreeNode currentNode = currentObj.node;
                TreeNode currentParent = currentObj.parent;

                if(currentNode.val == x)
                    parentOfx = currentParent;

                if(currentNode.val == y)
                    parentOfy = currentParent;

                if(currentNode.left != null)
                    queue.add(new Pair(currentNode.left, currentNode));

                if(currentNode.right != null)
                    queue.add(new Pair(currentNode.right, currentNode));
            }
            
            if(parentOfx != null && parentOfy != null)
                if(parentOfx.val != parentOfy.val)
                    return true;
            
            if(parentOfx != null || parentOfy != null)
                return false;
        }
        
        return false;
    }
}