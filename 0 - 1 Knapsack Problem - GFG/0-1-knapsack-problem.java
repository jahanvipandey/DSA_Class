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
        return profit(W, wt, val, n, 0, new HashMap<String, Integer>());
    } 
    
    static int profit(int weight, int[] wt, int[] val, int n, int currentItem, HashMap<String, Integer> memo){
        if(currentItem == n || weight == 0)
            return 0;
            
        int currentValue = val[currentItem];
        int currentWeight = wt[currentItem];
        
        String key = Integer.toString(weight) + "-" + Integer.toString(currentItem);
        if(memo.containsKey(key))
            return memo.get(key);
            
        int consider = 0;
        if(currentWeight <= weight)
            consider = currentValue + profit(weight - currentWeight, wt, val, n, currentItem + 1, memo);
        
        int notConsider = profit(weight, wt, val, n, currentItem + 1, memo);
        
        memo.put(key, Math.max(consider, notConsider));
        return memo.get(key);
    }
}


