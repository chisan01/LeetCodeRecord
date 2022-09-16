class Solution {

    final static int INF = 1000000009;

    int[] nums, mulipliers;
    int[][] dp;

    int recur(int startIdx, int i) {
        if (i == mulipliers.length) return 0;
        if (dp[startIdx][i] != INF) return dp[startIdx][i];

        int endIdx = (nums.length - 1) - (i - startIdx);
        if (startIdx == endIdx) return nums[startIdx] * mulipliers[i];
        return dp[startIdx][i] = Math.max(
                recur(startIdx + 1, i + 1) + nums[startIdx] * mulipliers[i],
                recur(startIdx, i + 1) + nums[endIdx] * mulipliers[i]
        );
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.mulipliers = multipliers;

        dp = new int[nums.length][multipliers.length];
        for (int[] rows : dp) Arrays.fill(rows, INF);

        return recur(0, 0);
    }
}