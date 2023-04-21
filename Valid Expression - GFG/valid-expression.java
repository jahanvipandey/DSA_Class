//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        Stack<Character> stack = new Stack<>();
        
        for(Character chr : s.toCharArray()){
            if(chr == '(' || chr == '[' || chr == '{'){
                stack.push(chr);
            } else {
                if(stack.isEmpty())
                    return false;
                    
                if(chr == ')' && stack.peek() != '(')
                    return false;
                    
                if(chr == '}' && stack.peek() != '{')
                    return false;
                    
                if(chr == ']' && stack.peek() != '[')
                    return false;
                    
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
} 