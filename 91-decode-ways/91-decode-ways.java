class Solution {
    
    String s;
    int[] dp;
    
    int f(int i) {
        if(i > s.length()) return 0;
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        
        int ret = f(i+1);
        
        if(i == s.length() - 1) return dp[i] = ret;
        
        if(s.charAt(i) == '1' || (s.charAt(i) == '2' && (s.charAt(i+1) - '0') <= 6)) ret += f(i+2);
        return dp[i] = ret;
    }
    
    public int numDecodings(String s) {
        this.s = s;   
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        
        return f(0);
    }
}