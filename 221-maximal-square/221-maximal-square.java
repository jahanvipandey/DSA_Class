class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        int area = 0;
        
        for(int currentRow = 0; currentRow < m; currentRow++){
             for(int currentCol = 0; currentCol < n; currentCol++){
                if(matrix[currentRow][currentCol] == '1'){
                    int side = maxLen(matrix, currentRow, currentCol, m, n, memo);
                    area = Math.max(area, side * side);
                }
            }
        }
           
        return area;
    }
    
    private int maxLen(char[][] matrix, int currentRow, int currentCol, int m, int n, HashMap<String, Integer> memo){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 ||currentCol >= n || matrix[currentRow][currentCol] == '0')
            return 0;
        
        String key = currentRow + "-" + currentCol;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = 1 + maxLen(matrix, currentRow, currentCol+1, m, n, memo);
        int down = 1 + maxLen(matrix, currentRow+1, currentCol, m, n, memo);
        int rightDiag = 1 + maxLen(matrix, currentRow+1, currentCol+1, m, n, memo);
        
        memo.put(key, Math.min(right, Math.min(down, rightDiag)));
        
        return memo.get(key);
    }
}