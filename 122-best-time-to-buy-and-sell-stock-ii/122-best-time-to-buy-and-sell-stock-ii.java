class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        
        for(int i = 0; i < prices.length; i++)
            for(int j = 0; j < 2; j++)
                dp[i][j] = -1;
        
        return profit(0, 1, prices, dp);
    }
    
    private int profit(int currentIndex, int canBuy, int[] prices, int[][] dp){
        if(currentIndex >= prices.length)
            return 0;

        if(dp[currentIndex][canBuy] != -1)
            return dp[currentIndex][canBuy];
        
        int idel = profit(currentIndex + 1, canBuy, prices, dp);
        
        int buy = 0;
        if(canBuy == 1){
            buy = -(prices[currentIndex]) + profit(currentIndex + 1, 0, prices, dp);
        } else if(canBuy == 0){
            buy = prices[currentIndex] + profit(currentIndex + 1, 1, prices, dp);
        }               

        dp[currentIndex][canBuy] = Math.max(idel, buy);
        return dp[currentIndex][canBuy];
    }
}