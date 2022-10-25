class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(0, 0, s1, s2, s1.length(), s2.length(), new HashMap<String, Integer>());
    }
    
    private int lcs(int i, int j, String s1, String s2, int m, int n, HashMap<String, Integer> memo){
        if(i >= m || j >= n)
            return 0;
        
        int ans = 0;
        
        String key = Integer.toString(i) + "-" + Integer.toString(j);
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + lcs(i+1, j+1, s1, s2, m, n, memo);
        } else {
            int a = lcs(i, j+1, s1, s2, m, n, memo);
            int b = lcs(i+1, j, s1, s2, m, n, memo);
            ans = Math.max(a,b);
        }
        
        memo.put(key, ans);
        return memo.get(key);
    }
}