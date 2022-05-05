class Solution {
    public int fib(int n) {
        return fibb(n);
    }
    
    private int fibb(int currentNum) {
         
        if(currentNum == 1)
            return 1;
        
        if(currentNum == 0)
            return 0;
        
        int answer = fibb(currentNum - 1) + fibb(currentNum - 2);
        
        return answer;
    }
}