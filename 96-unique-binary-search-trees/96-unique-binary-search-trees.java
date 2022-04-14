class Solution {
    public int numTrees(int n) {
        return catalan(n, new HashMap<Integer, Integer>());
    }
    
    private int catalan(int n, HashMap<Integer, Integer> memo){
        if (n == 0 || n == 1)
            return 1;
        
        int ways = 0;
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        for(int i = 0; i < n; i++)
            ways += catalan(i, memo) * catalan(n - i - 1, memo);
        
        memo.put(currentKey, ways);
        
        return memo.get(currentKey);
    }
}