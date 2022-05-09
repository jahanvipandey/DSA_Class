/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root == null)
            return answer;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            
            List<Integer> level = new ArrayList<>();
            
            while(queueSize > 0){
                Node currentNode = queue.remove();
                level.add(currentNode.val);
                
                for(Node currentChild : currentNode.children)
                    queue.add(currentChild);
                    
                queueSize -= 1;
            }
            
            answer.add(level);
        }
        
        return answer;
    }
}