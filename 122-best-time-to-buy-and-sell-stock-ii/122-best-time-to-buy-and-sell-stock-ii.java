class Solution {
    public int maxProfit(int[] prices) {
        return maximumProfit(prices, 0, 1, new HashMap<>());
    }
    
    private int maximumProfit(int[] prices, int currentDay, int canBuy, HashMap<String, Integer> memo){
        if (currentDay == prices.length)
            return 0;
        
        String currentKey = currentDay + "-" + canBuy;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans = 0;
        
        if(canBuy == 1){
            int idel = maximumProfit(prices, currentDay+1, canBuy, memo);
            int buy = -prices[currentDay] + maximumProfit(prices, currentDay+1, 0, memo);
            ans = Math.max(idel, buy);
        } else {
            int idel = maximumProfit(prices, currentDay+1, canBuy, memo);
            int sell = prices[currentDay] + maximumProfit(prices, currentDay+1, 1, memo);
            ans = Math.max(idel, sell);
        }
        
        memo.put(currentKey, ans);
        return ans;
    }
}