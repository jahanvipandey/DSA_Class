// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
     static int knapSack(int W, int wt[], int val[], int n) 
    { 
        HashMap<String, Integer> memo = new HashMap<>();
        return profit(W, 0, wt, val, n, memo); // your code here 
    } 
    
    private static int profit(int w, int currentIndex, int[] wt, int[] val, int n, HashMap<String, Integer> memo){
        if (currentIndex == n)
            return 0;
            
        if(w == 0)
            return 0;
            
        int currentWeight = wt[currentIndex];
        int currentvalue = val[currentIndex];
        
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(w);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int consider = 0;
        
        if(currentWeight <= w)
            consider = currentvalue + profit(w-currentWeight, currentIndex+1, wt, val, n, memo);
        
        int notConsider = profit(w, currentIndex+1, wt, val, n, memo);
        
        memo.put(currentKey, Math.max(consider, notConsider));
        return memo.get(currentKey);
    }
}


