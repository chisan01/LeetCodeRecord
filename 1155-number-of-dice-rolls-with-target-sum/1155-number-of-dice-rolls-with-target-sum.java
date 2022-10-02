class Solution {
    
    final int MOD = 1000000007;
    
    int[][] dp;
    
    int numOfDice, maxNumOfDice, targetSum;
    
    int f(int usedDiceCnt, int curSum) {
        if(usedDiceCnt == numOfDice) {
            if(curSum == targetSum) return 1;
            else return 0;
        } 
        if(curSum > targetSum) return 0;
        
        if(dp[usedDiceCnt][curSum] != -1) return dp[usedDiceCnt][curSum];
        
        long ret = 0;
        for(int i=1; i<=maxNumOfDice; i++) {
            ret += f(usedDiceCnt+1, curSum + i);
            ret %= MOD;
        }
        return dp[usedDiceCnt][curSum] = (int) ret;
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        this.numOfDice = n;
        this.maxNumOfDice = k;
        this.targetSum = target;
        
        dp = new int[n+1][target+1];
        for(int[] r : dp) Arrays.fill(r, -1);
        
        return f(0, 0);
    }
}