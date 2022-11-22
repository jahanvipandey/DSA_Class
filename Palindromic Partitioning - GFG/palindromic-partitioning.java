//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int[][] dp = new int[str.length()+1][str.length()+1];
        
        for(int i = 0; i <= str.length(); i++)
            for(int j = 0; j <= str.length(); j++)
                dp[i][j] = -1;
                
        return partition(0, str.length()-1, str, dp);
    }
    
    static int partition(int i, int j, String s, int[][] dp){
        if(i >= j)
            return 0;
            
        if(isPalindrom(i, j, s) == true)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
           
        for(int k = i; k <= j-1; k++){
            int tmp = 1 + partition(i, k, s, dp) + partition(k+1, j, s, dp);
            ans = Math.min(ans, tmp);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    
    static boolean isPalindrom(int i, int j, String s){
        while(i <= j){
            
            if(s.charAt(i) != s.charAt(j))
                return false;
            
            i += 1;
            j -= 1;
        }
        
        return true;
    }
}