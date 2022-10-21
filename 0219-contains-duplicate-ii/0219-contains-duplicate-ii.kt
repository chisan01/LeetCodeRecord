import kotlin.math.min

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        for (i in nums.indices) {

            val curNum = nums[i]

            for (j in i + 1..min(nums.lastIndex, i + k)) {
                if(curNum == nums[j]) return true
            }
        }
        return false
    }
}