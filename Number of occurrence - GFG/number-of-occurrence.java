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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int first = firstPosition(arr, x);
        
        if(first == -1)
            return 0;
            
        int last = lastPosition(arr, x);
        int answer = (last - first) + 1;
        return answer;
    }
    
    public int firstPosition(int[] nums, int target){
        int answer = -1;
        int start = 0; 
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                answer = mid;
                end = mid - 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public int lastPosition(int[] nums, int target){
        int answer = -1;
        int start = 0; 
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                answer = mid;
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}