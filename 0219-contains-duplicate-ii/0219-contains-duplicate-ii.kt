import kotlin.math.min

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val subNumsLengthOfK = mutableSetOf<Int>()
        for (i in nums.indices) {
            val num = nums[i]
            if(i > k) subNumsLengthOfK.remove(nums[i - k - 1])
            if(subNumsLengthOfK.contains(num)) return true
            subNumsLengthOfK.add(num)
        }
        return false
    }
}