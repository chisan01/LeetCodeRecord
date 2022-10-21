class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val recentPosOfNum = mutableMapOf<Int, Int>()
        for (curPos in nums.indices) {
            val curNum = nums[curPos]

            val prevPos = recentPosOfNum[curNum] ?: -987654321
            if(curPos - prevPos <= k) return true;
            
            recentPosOfNum[curNum] = curPos
        }
        return false
    }
}