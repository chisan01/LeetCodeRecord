class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val dp = MutableList(nums.size) { mutableMapOf<Long, Int>() }

        var ret = 0
        for (i in nums.indices) {
            for (j in 0 until i) {
                val diff = nums[j].toLong() - nums[i].toLong()

                val sum = dp[j].getOrDefault(diff, 0)
                dp[i][diff] = dp[i].getOrDefault(diff, 0) + sum + 1
                ret += sum
            }
        }
        return ret
    }
}