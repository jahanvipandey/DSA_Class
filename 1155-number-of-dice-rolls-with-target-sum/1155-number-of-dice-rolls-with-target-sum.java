class Solution {
    int[][] matrix;
    int mod = (int)Math.pow(10, 9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        matrix = new int[n+1][target+1];
        for (int[] row : matrix)
            Arrays.fill(row, -1);
        return sum(n, k, target);
    }

    private int sum(int n, int k, int currSum) {
        if (n == 0 && currSum == 0) {
            return 1;
        }
        if (n == 0 || currSum <= 0)
            return 0;

        if (matrix[n][currSum] != -1)
            return matrix[n][currSum];

        int combos = 0;
        for (int i=1; i<=k; i++) {
            combos = (combos + (sum(n - 1, k, currSum - i) % mod)) % mod;
        }
        return matrix[n][currSum] = combos;
    }
}