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
        int[][] dp = new int[n][W+1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < W+1; j++)
                dp[i][j] = -1;
        return maxProfit(0, W, wt, val, n, dp);
    } 
    static public int maxProfit(int currentItem, int weight, int[] wt, int[] val, int n, int[][] dp){
        if (weight == 0 || currentItem >= n)
            return 0;
            
        int currentWeight = wt[currentItem];
        int currentValue = val[currentItem];
        
        if(dp[currentItem][weight] != -1)
            return dp[currentItem][weight];
        
        int consider = 0;
        if(weight >= currentWeight)
            consider = currentValue + maxProfit(currentItem + 1, weight - currentWeight, wt, val, n, dp);
        int notConsider = maxProfit(currentItem+1, weight, wt, val, n, dp);
        
        dp[currentItem][weight] = Math.max(consider, notConsider);
        return  Math.max(consider, notConsider);
    }
    
}


