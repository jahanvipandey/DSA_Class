class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return totalSteps(0, n, memo);
    }
    
    private int totalSteps(int currentSteps, int n,HashMap<Integer, Integer> memo) {
        
        int answer = 0;
        if(currentSteps > n)
            return 0;
        
        if(currentSteps == n)
            return 1;
        
        int currentKey = currentSteps;
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        answer = totalSteps(currentSteps + 1, n, memo) + totalSteps(currentSteps + 2, n, memo);
        
        memo.put(currentKey, answer);
        
        return memo.get(currentKey);
    }
}