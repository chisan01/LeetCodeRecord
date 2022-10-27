import kotlin.math.*

class Solution {
    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {

        val posOf1InImg1 = mutableListOf<Int>()
        val posOf1InImg2 = mutableListOf<Int>()

        for (i in img1.indices) {
            for (j in img1[0].indices) {
                if(img1[i][j] == 1) posOf1InImg1.add(i * 40 + j)
                if(img2[i][j] == 1) posOf1InImg2.add(i * 40 + j)
            }
        }

        val translationCnt = mutableMapOf<Int, Int>()
        for (pos1 in posOf1InImg1) {
            for (pos2 in posOf1InImg2) {
                val diff = pos1 - pos2
                translationCnt[diff] = translationCnt.getOrDefault(diff, 0) + 1
            }
        }

        var result = 0
        for (cnt in translationCnt.values) {
            result = max(result, cnt)
        }
        return result
    }
}