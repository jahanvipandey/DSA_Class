class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        return minSum(0, 0, m, n, grid, memo);
    }
    
    private int minSum(int row, int col, int m, int n, int[][] grid,  HashMap<String, Integer> memo){
        if(row >= m || col >= n)
            return 100001;
        
        if(row == m-1 && col == n-1)
            return grid[row][col];
        
        String key = row + "-" + col;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = grid[row][col] + minSum(row, col+1, m, n, grid, memo);
        int down = grid[row][col] + minSum(row+1, col, m, n, grid, memo);
        
        memo.put(key, Math.min(right, down));
        
        return memo.get(key);
    }
}