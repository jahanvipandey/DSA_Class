/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = findParent(root);

        return find(root, target, k, parentMap);
    }
    
    private List<Integer> find(TreeNode root, TreeNode target, int k, HashMap<TreeNode, TreeNode> parentMap){
        List<Integer> answer = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        
        iterateTree(target, k, answer, visited, parentMap);
        return answer;
    }
    
    private void iterateTree(TreeNode currentNode, int k, List<Integer> answer, HashSet<TreeNode> visited, HashMap<TreeNode, TreeNode> parentMap) {
        
        if(currentNode == null || visited.contains(currentNode))
            return;
        
        visited.add(currentNode);
            
        if(k == 0){
            answer.add(currentNode.val);
            return;
        }
        iterateTree(currentNode.left, k-1, answer, visited, parentMap);
        iterateTree(currentNode.right, k-1, answer, visited, parentMap);
        iterateTree(parentMap.get(currentNode), k-1, answer, visited, parentMap);
    }
    
    private HashMap<TreeNode, TreeNode> findParent(TreeNode root){
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParentMap(root, null, parentMap);
        return parentMap;
    }
    
    private void findParentMap(TreeNode currentNode, TreeNode currentParent, HashMap<TreeNode, TreeNode> parentMap){
        if(currentNode == null)
            return;
        
        parentMap.put(currentNode, currentParent);
        
        findParentMap(currentNode.left, currentNode, parentMap);
        findParentMap(currentNode.right, currentNode, parentMap);
        return;
    }
}