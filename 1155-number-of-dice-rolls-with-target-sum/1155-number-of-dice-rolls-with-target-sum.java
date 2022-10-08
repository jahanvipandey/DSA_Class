class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return possibleWays(n, target, k, new HashMap<String, Integer>());
    }
    
    private int possibleWays(int n, int target, int faces, HashMap<String, Integer> memo){
        
        if(n == 0 && target == 0)
            return 1;
        
        if(target <= 0 || n == 0)
            return 0;
        
        String key = Integer.toString(n) + '-' + Integer.toString(target);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = 0;
        int MOD = (int)(Math.pow(10, 9)) + 7; //1e9 + 7
        
        for(int i = 1; i <= faces; i++){
            int tempAns = possibleWays(n-1, target-i, faces, memo) % MOD;
            ans = ans % MOD;
            ans = (ans + tempAns) % MOD;
            
            //ans += possibleWays(n-1, target-i, faces, memo);
        }
        
        memo.put(key, ans);
        return memo.get(key);
    }
}