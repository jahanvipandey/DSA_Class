// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String s) 
    { 
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        long answer = 0;
        
        String expr = (z0-z1) + "-" + (z2-z1);
        HashMap<String, Integer> memo = new HashMap<>();
        memo.put(expr, 1);
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')
                z0 += 1;
            else if(s.charAt(i) == '1')
                z1 += 1;
            else
                z2 += 1;
                
            expr = (z0-z1) + "-" + (z2-z1);
            
            if(memo.containsKey(expr)){
                answer += memo.get(expr);
                memo.put(expr, memo.get(expr)+1);
            } else
                memo.put(expr, 1);
        }
        return answer;
    }
} 