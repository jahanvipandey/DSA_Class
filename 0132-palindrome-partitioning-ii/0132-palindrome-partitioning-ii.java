class Solution {
    public int minCut(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < s.length(); j++)
                dp[i][j] = -1;
        
        return minimumCut(start, end, s, dp);
    }
    
    private int minimumCut(int start, int end, String s, int[][] dp){
        
        if(checkPalindrom(start, end, s))
            return 0;
        
        if(dp[start][end] != -1)
            return dp[start][end];
        
        int ans = 100000000;
        for(int i = start; i < end; i++){
            if(checkPalindrom(start, i, s)){
                int tempAns = 1 + minimumCut(i+1, end, s, dp);
                ans = Math.min(ans, tempAns);
            }   
        }
        
        dp[start][end] = ans;
        return dp[start][end];
    }
    
    private boolean checkPalindrom(int start, int end, String s){
        while(start <= end){
            
            if(s.charAt(start) != s.charAt(end))
                return false;
            
            start += 1;
            end -= 1;
        }
        
        return true;
    }
}