class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>(Pair(0, -1))
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if(k != 0) sum %= k

            if (map.containsKey(sum)) {
                if(i - map[sum]!! > 1) return true
            } else map[sum] = i
        }
        return false
    }
}