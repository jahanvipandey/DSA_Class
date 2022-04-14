class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        HashMap <String, Integer> memo = new HashMap<>();
        
        return maxPath(0, 0, m, n, obstacleGrid, memo);
    }
    
    private int maxPath(int row, int col, int m, int n, int[][] grid, HashMap <String, Integer> memo){
        if(row >= m || col >= n || grid[row][col] == 1)
            return 0;
        
        if(row == m-1 && col == n-1)
            return 1;
        
        String key = row + "-" + col;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = maxPath(row, col+1, m, n, grid, memo);
        int down = maxPath(row+1, col, m, n, grid, memo);
        
        memo.put(key, right+down);
        
        return memo.get(key);
    }
}