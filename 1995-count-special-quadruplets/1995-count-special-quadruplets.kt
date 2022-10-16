class Solution {
    fun countQuadruplets(nums: IntArray): Int {

        var cnt: Int = 0

        for (a in 0 until nums.size - 3) {
            for (b in a + 1 until nums.size - 2) {
                for (c in b + 1 until nums.size - 1) {
                    for (d in c + 1 until nums.size) {
                        if(nums[a] + nums[b] + nums[c] == nums[d]) cnt++
                    }
                }
            }
        }
        
        return cnt;
    }
}