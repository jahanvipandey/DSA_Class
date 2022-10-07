class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0]. length;
        int ans = 1000001;
        
        int[][] dp = new int[m][n];
        for(int i = 0; i <= m-1; i++)
            for(int j = 0; j <= n-1; j++)
                dp[i][j] = -1;
        
        for(int i = 0; i < n; i++){
            int tempAns = minSum(0, i, m, n, matrix, dp);
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }
    
    private int minSum(int r, int c, int m, int n, int[][] matrix, int[][] dp){
        if(c <= -1 || c >= n)
            return 10000001;
        
        if(r == m-1)
            return matrix[r][c];
        
        if(dp[r][c] != -1)
            return dp[r][c];
        
        int leftBottom = matrix[r][c] + minSum(r+1, c-1, m, n, matrix, dp);
        int down = matrix[r][c] + minSum(r+1, c, m, n, matrix, dp);
        int rightBottom = matrix[r][c] + minSum(r+1, c+1, m, n, matrix, dp);
        
        dp[r][c] = Math.min(Math.min(leftBottom, down), rightBottom);
        return dp[r][c];
    }
}