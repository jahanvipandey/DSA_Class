class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<>();
        return maxPath(0, 0, m, n, memo);
    }
    
    private int maxPath(int currentRow, int currentCol, int m, int n, HashMap<String, Integer> memo){
        if(currentRow >= m || currentCol >= n)
            return 0;
        
        if(currentRow == m-1 && currentCol == n-1)
            return 1;
        
        String key = currentRow + "-" + currentCol;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = maxPath(currentRow, currentCol+1, m, n, memo);
        int down = maxPath(currentRow+1, currentCol, m, n, memo);
        
        memo.put(key, right+down);
        
        return memo.get(key);
    }
}