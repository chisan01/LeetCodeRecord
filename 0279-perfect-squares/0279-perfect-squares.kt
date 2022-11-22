const val MAX_VALUE = 10000

class Solution {

    fun numSquares(n: Int): Int {
        val dp = MutableList(10001) { MAX_VALUE + 1 }
        for (i in 1..100) {
            dp[i*i] = 1
        }

        for (curNum in 1..MAX_VALUE) {
            if(dp[curNum] > MAX_VALUE) continue

            for (j in 1..100) {
                val nextNum = curNum + j*j
                if(nextNum > MAX_VALUE) break
                if(dp[nextNum] <= dp[curNum] + 1) continue
                dp[nextNum] = dp[curNum] + 1
            }
        }

        return dp[n]
    }
}