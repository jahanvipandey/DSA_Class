class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(0, cost, new HashMap<Integer, Integer>()), minCost(1, cost, new HashMap<Integer, Integer>())); 
    }
    
    private int minCost(int currentIndex, int[] currentCost, HashMap<Integer, Integer> memo){
        
        if(currentIndex == currentCost.length)
            return 0;
        
        if(currentIndex > currentCost.length)
            return 1001;
        
        int key = currentIndex;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int onejump = 0;
        int twojump = 0;
        
        if(currentIndex < currentCost.length){
            onejump = currentCost[currentIndex] + minCost(currentIndex + 1, currentCost, memo);
            twojump = currentCost[currentIndex] + minCost(currentIndex + 2, currentCost, memo);
        }
        
        memo.put(key, Math.min(onejump, twojump));
        
        return memo.get(key);
    }
}