class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(climbingStairs(0, cost, memo), climbingStairs(1, cost, memo));
    }
    
    private int climbingStairs(int currentStair, int[] cost, HashMap<Integer, Integer> memo) {
        
        if(currentStair >= cost.length)
            return 0;
        
        int key = currentStair;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int oneStep = cost[currentStair] + climbingStairs(currentStair + 1, cost, memo);
        int twoStep = cost[currentStair] + climbingStairs(currentStair + 2, cost, memo);
        
        memo.put(key, Math.min(oneStep, twoStep));
        
        return memo.get(key);
    }
}