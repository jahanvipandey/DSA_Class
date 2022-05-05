class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return fibb(n, memo);
    }
    
    private int fibb(int currentNum, HashMap<Integer, Integer> memo) {
         
        if(currentNum == 1)
            return 1;
        
        if(currentNum == 0)
            return 0;
        
        int key = currentNum;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int answer = fibb(currentNum - 1, memo) + fibb(currentNum - 2, memo);
        
        memo.put(key, answer);
        
        return memo.get(key);
    }
}