class Solution {
    fun orderlyQueue(s: String, k: Int): String {
        return if(k > 1) s.toCharArray().sortedArray().joinToString("")
        else {
            var result = s
            var movedS = s
            repeat(s.length) {
                movedS = movedS.substring(1) + movedS[0]
                if(movedS < result) result = movedS
            }
            result
        }
    }
}