class Solution {
    
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] matrix;
        int mod = (int)Math.pow(10, 9) + 7;
        
        matrix = new int[n+1][target+1];
        for (int[] row : matrix)
            Arrays.fill(row, -1);
        return sum(n, k, target, matrix, mod);
    }

    private int sum(int n, int k, int currSum, int[][] matrix, int mod) {
        if (n == 0 && currSum == 0) {
            return 1;
        }
        if (n == 0 || currSum <= 0)
            return 0;

        if (matrix[n][currSum] != -1)
            return matrix[n][currSum];

        int combos = 0;
        for (int i=1; i<=k; i++) {
            combos = (combos + (sum(n - 1, k, currSum - i, matrix, mod) % mod)) % mod;
        }
        return matrix[n][currSum] = combos;
    }
}