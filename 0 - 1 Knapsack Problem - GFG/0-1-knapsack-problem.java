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
         return maxProfit(0, W, wt, val, n, memo);
    } 
    
    static int maxProfit(int currentIndex, int capacity, int[] weight, int[] profit, int n,  HashMap<String, Integer> memo){
        
        if(currentIndex == n)
            return 0;
            
        int currentWeight = weight[currentIndex];
        int currentProfit = profit[currentIndex];
        
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(capacity);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
            
        int consider = 0;
            
        if(currentWeight <= capacity)
            consider = currentProfit + maxProfit(currentIndex+1, capacity - currentWeight, weight, profit, n, memo);
        
        int notConsider = maxProfit(currentIndex+1, capacity, weight, profit, n, memo);
        
        memo.put(currentKey, Math.max(consider, notConsider));
        return memo.get(currentKey);
        }
}


