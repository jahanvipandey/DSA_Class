// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] memo = new int[N][W+1];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < W+1; j++)
                memo[i][j] = -1;
                
        return maxProfit(N, W, val, wt, 0, memo);
    }
    
    static int maxProfit(int n, int capacity, int[] val, int[] wt, int currentItem, int[][] memo){
        if(currentItem >= n || capacity == 0)
            return 0;
        
        int currentWeight = wt[currentItem];
        int currentVal = val[currentItem];
        
        if(memo[currentItem][capacity] != -1)
            return memo[currentItem][capacity];
            
        int consider = 0;  
        if(wt[currentItem] <= capacity)
            consider = currentVal + maxProfit(n, capacity - currentWeight, val, wt, currentItem, memo);
        
        int notConsider = maxProfit(n, capacity, val, wt, currentItem+1, memo);
        
        memo[currentItem][capacity] = Math.max(consider, notConsider);
        return memo[currentItem][capacity];
    }
}