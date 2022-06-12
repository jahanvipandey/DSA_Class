class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++)
            for(int j = 0; j < amount+1; j++)
                memo[i][j] = -1;
        
        return findAmount(amount, coins, 0, memo);
    }
    private int findAmount(int amount, int[] coins, int currentCoin, int[][] memo){
        if(amount == 0)
            return 1;
        
        if(currentCoin == coins.length)
            return 0;
        
        if(memo[currentCoin][amount] != -1)
            return memo[currentCoin][amount];
        
        int consider = 0;
        if(coins[currentCoin] <= amount)
            consider = findAmount(amount - coins[currentCoin], coins, currentCoin, memo);
        
        int notConsider = findAmount(amount, coins, currentCoin+1, memo);
        
        memo[currentCoin][amount] = consider + notConsider;
        return memo[currentCoin][amount];
    }
    
}