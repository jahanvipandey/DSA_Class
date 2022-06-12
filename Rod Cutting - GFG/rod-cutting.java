// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        return maxPrice(price, n, 0, new HashMap<String, Integer>());
    }
    
    private int maxPrice(int[] price, int length, int currentPiece, HashMap<String, Integer> memo){
        if(length == 0)
            return 0;
            
        if(currentPiece == price.length)
            return 0;
            
        String key = Integer.toString(currentPiece) + "-" + Integer.toString(length);
        if(memo.containsKey(key))
            return memo.get(key);
    
        int consider = 0;
        if((currentPiece+1) <= length)
            consider = price[currentPiece] + maxPrice(price, length - (currentPiece + 1), currentPiece, memo);
        
        int notConsider = maxPrice(price, length, currentPiece+1, memo);
        
        memo.put(key, Math.max(consider, notConsider));
        return memo.get(key);
    }
}