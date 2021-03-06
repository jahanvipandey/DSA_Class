// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int totalSum = 0;
        for(int nums : arr)
            totalSum += nums;
            
        if(totalSum % 2 != 0)
            return 0;
            
        return equalSum(N, arr, 0, totalSum/2, new HashMap<String, Boolean>()) == true ? 1 : 0;
    }
    
    static boolean equalSum(int n, int[] nums, int currentItem, int targetSum, HashMap<String, Boolean> memo){
        if(targetSum == 0)
            return true;
            
        if(currentItem >= n)
            return false;
            
        String key = Integer.toString(currentItem) + "-" + Integer.toString(targetSum);
        if(memo.containsKey(key))
            return memo.get(key);
            
        boolean consider = false;
        
        if(nums[currentItem] <= targetSum){
            consider = equalSum(n, nums, currentItem+1, targetSum - nums[currentItem], memo);
            
            if(consider == true)
                return true;
        }
            
        boolean notConsider = equalSum(n, nums, currentItem+1, targetSum, memo);
        
        memo.put(key, consider || notConsider);
        return memo.get(key);
    }
}