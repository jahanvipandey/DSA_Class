// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        return calCat(n, new HashMap<Integer, BigInteger>());
        
    }
    
    static private BigInteger calCat(int n, HashMap<Integer, BigInteger> memo){
        if(n == 0 || n == 1)
            return new BigInteger("1");
            
        BigInteger ways = new BigInteger("0");
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        for(int i = 0; i < n; i++){
            BigInteger a = calCat(i, memo);
            BigInteger b = calCat(n - i - 1, memo);
            BigInteger c = a.multiply(b);
            ways = ways.add(c);
        }
        
        memo.put(currentKey, ways);
        
        return memo.get(currentKey);
    }
}