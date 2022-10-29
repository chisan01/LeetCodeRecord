class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            sum %= k

            if (sum == 0 && i > 0) return true
            if (i - (map[sum] ?: i) > 1) return true
            if(!map.containsKey(sum)) map[sum] = i
        }
        return false
    }
}