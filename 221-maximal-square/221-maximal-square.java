class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maximum = 0;
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == '1'){
                    int length = findLength(i, j, m, n, matrix, memo);
                    maximum = Math.max(maximum, length*length);
                }    
            }
        
        return maximum;
    }
    
    private int findLength(int r, int c, int m, int n, char[][] matrix, HashMap<String, Integer> memo){
        if(r >= m || c >= n || r < 0 || c < 0 || matrix[r][c] == '0')
            return 0;
        
        String key = Integer.toString(r) + '-' + Integer.toString(c);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = 1 + findLength(r, c+1, m, n, matrix, memo);
        int down = 1 + findLength(r+1, c, m, n, matrix, memo);
        int rightDiagonal = 1 + findLength(r+1, c+1, m, n, matrix, memo);
        
        memo.put(key, Math.min(Math.min(right, down), rightDiagonal));
        return memo.get(key);
    }
}