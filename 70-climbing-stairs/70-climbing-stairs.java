class Solution {
    public int climbStairs(int n) {
        return totalways(0, n, new HashMap<Integer, Integer>());
    }
    
    private int totalways(int currentStair, int targetStair, HashMap<Integer, Integer> memo){
        
        if(currentStair == targetStair)
            return 1;
        
        if(currentStair > targetStair)
            return 0;
        
        int key = currentStair;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int onejump = totalways(currentStair + 1, targetStair, memo);
        int twojump = totalways(currentStair + 2, targetStair, memo);
        
        memo.put(key, onejump + twojump);
        return memo.get(key);
    }
}