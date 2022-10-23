class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val set = mutableSetOf<Int>()
        
        var duplicateNum = 0
        for(num in nums) {
            if(set.contains(num)) duplicateNum = num
            else set.add(num)
        }
        
        var missingNum = 0
        for (i in 1..nums.size) {
            if(set.contains(i)) continue
            missingNum = i
            break
        }
        
        return listOf(duplicateNum, missingNum).toIntArray()
    }
}