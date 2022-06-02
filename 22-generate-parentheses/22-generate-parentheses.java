class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generate(0, 0, "", n, answer);
        return answer;
    }
    
    private void generate(int openCount, int closeCount, String expression, int n, List<String> answer){
        if(openCount == closeCount && openCount == n){
            answer.add(expression);
            return;
        }
        
        if(openCount < n)
            generate(openCount+1, closeCount, expression + "(", n, answer);
        
        if(closeCount < openCount)
            generate(openCount, closeCount+1, expression + ")", n, answer);
        
        return;
    }
}