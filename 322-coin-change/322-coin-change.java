class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++)
            for(int j = 0; j < amount+1; j++)
                memo[i][j] = -1;
        
        int answer = minCoin(coins, amount, 0, memo);
        if(answer >= 10001)
            answer = -1;
        return answer;
    }
    
    private int minCoin(int[] coins, int amount, int currentCoin, int[][] memo) {
        if(amount == 0)
            return 0;
        
        if(currentCoin >= coins.length)
            return 10001;
        
        if(memo[currentCoin][amount] != -1)
            return memo[currentCoin][amount];
        
        int consider = 10001;
        if(coins[currentCoin] <= amount)
            consider = 1 + minCoin(coins, amount - coins[currentCoin], currentCoin, memo);
        
        int notConsider = minCoin(coins, amount, currentCoin+1, memo);
        
        memo[currentCoin][amount] = Math.min(consider, notConsider);
        return memo[currentCoin][amount];
    }
}