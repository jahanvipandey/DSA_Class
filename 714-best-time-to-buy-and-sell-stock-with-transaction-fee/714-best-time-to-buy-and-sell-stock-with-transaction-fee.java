class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maximumProfit(prices, 0, 1, 1, new HashMap<String, Integer>(), fee);
    }
    
    private int maximumProfit(int[] prices, int currentDay, int canBuy, int transCount, HashMap<String, Integer> memo, int fee){
        if (currentDay >= prices.length)
            return 0;
        
        String currentKey = currentDay + "-" + canBuy ;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans = 0;
        
        if(canBuy == 1){
            int idel = maximumProfit(prices, currentDay+1, canBuy, transCount, memo, fee);
            int buy = -prices[currentDay] + maximumProfit(prices, currentDay+1, 0, transCount, memo, fee);
            ans = Math.max(idel, buy);
        } else {
            int idel = maximumProfit(prices, currentDay+1, canBuy, transCount, memo, fee);
            int sell = -fee + prices[currentDay] + maximumProfit(prices, currentDay+1, 1, transCount-1, memo, fee);
            ans = Math.max(idel, sell);
        }
        
        memo.put(currentKey, ans);
        return ans;
    }
}