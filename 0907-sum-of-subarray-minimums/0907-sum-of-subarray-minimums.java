import java.util.PriorityQueue;
import java.util.Stack;

class Solution {

    final int MOD = 1000000007;

    int[] dp;

    public int sumSubarrayMins(int[] arr) {
        dp = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        int ret = 0;
        for (int lastIdx = 0; lastIdx < arr.length; lastIdx++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[lastIdx]) {
                stack.pop();
            }
            int curSum = 0;
            if (stack.isEmpty()) curSum += (arr[lastIdx]) * (lastIdx + 1) % MOD;
            else {
                curSum += (arr[lastIdx]) * (lastIdx - stack.peek()) % MOD;
                curSum += dp[stack.peek()];
            }
            dp[lastIdx] = curSum % MOD;
            ret = (ret + curSum) % MOD;

            stack.add(lastIdx);
        }
        return ret;
    }
}