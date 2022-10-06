class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        return minPath(0, 0, m, n, grid, new HashMap<String, Integer>());
    }
    
    private int minPath(int r, int c, int m, int n, int[][] grid, HashMap<String, Integer> memo){
        if(r >= m || c >= n)
            return 2001;
        
        if(r == m-1 && c == n-1)
            return grid[r][c];
        
        String key = Integer.toString(r) + '-' + Integer.toString(c);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = grid[r][c] + minPath(r, c+1, m, n, grid, memo);
        int down = grid[r][c] + minPath(r+1, c, m, n, grid, memo);
        
        memo.put(key, Math.min(right, down));
        
        return memo.get(key);
    }
}