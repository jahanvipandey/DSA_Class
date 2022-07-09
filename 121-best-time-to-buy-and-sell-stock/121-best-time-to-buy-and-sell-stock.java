class Solution {
    public int maxProfit(int[] prices) {
        return maximumProfit(prices, 0, 1, 1, new HashMap<String, Integer>());
    }
    
    private int maximumProfit(int[] prices, int date, int canbuy, int targetSum, HashMap<String, Integer> memo){
        if(date >= prices.length || targetSum == 0)
            return 0;
        
        String key = date + "-" + canbuy + "-" + targetSum;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(canbuy == 1){
            int idel = maximumProfit(prices, date+1, canbuy, targetSum, memo);
            int buy = -prices[date] + maximumProfit(prices, date+1, 0, targetSum, memo);
            
            memo.put(key, Math.max(idel, buy));
            return memo.get(key);
        } else {
            int idel = maximumProfit(prices, date+1, canbuy, targetSum, memo);
            int sell = prices[date] + maximumProfit(prices, date+1, 1, targetSum-1, memo);
            
            memo.put(key, Math.max(idel, sell));
            return memo.get(key);
        }
    }
}