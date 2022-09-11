class Solution {
    public int change(int amount, int[] coins) {
        return totalWays(0, amount, coins, new HashMap<String, Integer>());
    }
    
    private int totalWays(int current, int amount, int[] coins, HashMap<String, Integer> memo){
        if(amount == 0)
            return 1;
        
        if(current >= coins.length)
            return 0;
        
        String key = Integer.toString(current) + "-" + Integer.toString(amount);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = 0;
        if(coins[current] <= amount)
            consider = totalWays(current, amount - coins[current], coins, memo);
        
        int notConsider = totalWays(current + 1, amount, coins, memo);
        
        memo.put(key, consider + notConsider);
        return memo.get(key);
    }
}