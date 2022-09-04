class Solution {
    public int fib(int n) {
        return fibo(n, new HashMap<Integer, Integer>());
    }
    
    private int fibo(int n,HashMap<Integer, Integer> memo){
        
        if(n == 0)
            return 0;
        
        if(n == 1)
            return 1;
        
        int key = n;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        memo.put(key, fibo(n-1, memo) + fibo(n-2, memo));
        
        return memo.get(key);
    }
}