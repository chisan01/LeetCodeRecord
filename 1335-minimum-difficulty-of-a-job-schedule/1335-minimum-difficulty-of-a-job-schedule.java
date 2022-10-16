class Solution {

    final int INF = 987654321;

    int[] jobDifficulty;
    int[][] dp;

    int f(int leftDay, int finishWorkCnt) {
        int leftWorkCnt = jobDifficulty.length - finishWorkCnt;
        if (leftDay > leftWorkCnt) return INF;
        if (dp[leftDay][finishWorkCnt] != INF) return dp[leftDay][finishWorkCnt];

        int curMaxJobDifficulty = jobDifficulty[finishWorkCnt];
        for (int nextFinishWorkCnt = finishWorkCnt + 1; nextFinishWorkCnt <= jobDifficulty.length; nextFinishWorkCnt++) {
            curMaxJobDifficulty = Math.max(curMaxJobDifficulty, jobDifficulty[nextFinishWorkCnt - 1]);
            dp[leftDay][finishWorkCnt] = Math.min(
                    dp[leftDay][finishWorkCnt],
                    f(leftDay - 1, nextFinishWorkCnt) + curMaxJobDifficulty
            );
        }
        return dp[leftDay][finishWorkCnt];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;

        dp = new int[d + 1][jobDifficulty.length + 1];
        for (int r = 0; r < dp.length; r++) for (int c = 0; c < dp[0].length; c++) dp[r][c] = 987654321;

        dp[1][jobDifficulty.length - 1] = jobDifficulty[jobDifficulty.length - 1];
        for (int i = jobDifficulty.length - 2; i >= 0; i--) {
            dp[1][i] = Math.max(dp[1][i + 1], jobDifficulty[i]);
        }

        int ans = f(d, 0);
        return ans == INF ? -1 : ans;
    }
}