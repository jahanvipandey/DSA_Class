class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return possibleWays(n, target, k, dp);
    }
    
    private int possibleWays(int n, int target, int faces, int[][] dp){
        
        if(n == 0 && target == 0)
            return 1;
	
	if(target <= 0 || n == 0)
            return 0;
       
        int MOD = (int)(Math.pow(10, 9)) + 7; //1e9 + 7

	if(dp[n][target] != -1)
            return dp[n][target];
        
	int ans = 0;
        for(int i = 1; i <= faces; i++){
            int tempAns = possibleWays(n-1, target-i, faces, dp) % MOD;
            ans = ans % MOD;
            ans = (ans + tempAns) % MOD;
        }
        
        dp[n][target] = ans;
        return dp[n][target];
    }
}