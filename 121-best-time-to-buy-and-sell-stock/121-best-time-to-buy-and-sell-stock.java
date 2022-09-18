class Solution {
    public int maxProfit(int[] prices) {
        
        int[][][] dp = new int[prices.length][2][2];
        
        for(int i = 0; i < prices.length; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
        
        return profit(0, 1, 1, prices, dp);
    }
    
    private int profit(int currentIndex, int canBuy, int transaction, int[] prices, int[][][] dp){
        if(currentIndex >= prices.length || transaction == 0)
            return 0;
        
        //String key = Integer.toString(currentIndex) + "-" + Integer.toString(canBuy) + "-" + Integer.toString(transaction);
        
        // if(memo.containsKey(key))
        //     return memo.get(key);
        
        if(dp[currentIndex][canBuy][transaction] != -1)
            return dp[currentIndex][canBuy][transaction];
        
        int idel = profit(currentIndex + 1, canBuy, 1, prices, dp);
        
        int buy = 0;
        if(canBuy == 1){
            buy = -(prices[currentIndex]) + profit(currentIndex + 1, 0, transaction, prices, dp);
        } else if(canBuy == 0){
            buy = prices[currentIndex] + profit(currentIndex + 1, 1, transaction - 1, prices, dp);
        }               
        
//         int idel = 0;
//         int buy = 0;
//         if(canBuy == 1){
//             idel = profit(currentIndex + 1, canBuy, 1, prices);
//             buy = -(prices[currentIndex]) + profit(currentIndex + 1, 0, transaction, prices);
//         } else {
//             idel = profit(currentIndex + 1, canBuy, 1, prices);
//             buy = prices[currentIndex] + profit(currentIndex + 1, 1, transaction - 1, prices);
//         }
            
        dp[currentIndex][canBuy][transaction] = Math.max(idel, buy);
        return dp[currentIndex][canBuy][transaction];
    }
}