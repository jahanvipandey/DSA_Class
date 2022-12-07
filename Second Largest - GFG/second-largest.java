//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        
        int second = -1;
        int large = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[large]){
                second = large;
                large = i;
            } else if(arr[i] < arr[large]){
                if(second == -1 || arr[i] > arr[second])
                    second = i;
            }
        }
        if(second == -1)
            return -1;
        else
            return arr[second];
        
        // Naive approch
        // int largest = largest(arr, n);
        // int ans = -1;
        // for(int i = 0; i < n; i++){
        //     if(arr[i] != arr[largest]){
        //         if(ans == -1)
        //             ans = i;
        //         else if(arr[i] > arr[ans])
        //             ans = i;
        //     }
        // }
        // return arr[ans];
    }
    
    int largest(int[] arr, int n){
        int ans = 0;
        for(int i = 1; i < n; i++)
            if(arr[i] > arr[ans])
                ans = i;
        return ans;
    }
}