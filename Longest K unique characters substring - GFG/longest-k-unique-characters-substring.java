// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> memo = new HashMap<>();
        int distinct = 0; 
        int release = 0;
        int answer = 0;

        for(int acquire = 0; acquire < s.length(); acquire++){
            Character currentChar = s.charAt(acquire);

            if(memo.containsKey(currentChar)){
                memo.put(currentChar, memo.get(currentChar) + 1);
            } else {
                memo.put(currentChar, 1);
                distinct += 1;
            }

            while(release <= acquire && distinct > k){
                Character disChar = s.charAt(release);
                memo.put(disChar, memo.get(disChar) - 1);
                release += 1;

                if(memo.get(disChar) == 0){
                    memo.remove(disChar);
                    distinct -= 1;
                }
            }
            if(distinct == k)
                answer = Math.max(answer, acquire - release + 1);
        }
        return answer == 0 ? -1 : answer;
    }
}