import java.util.*

class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        for(i in 1..matrix.lastIndex) {
            matrix[i].forEachIndexed { j, item ->
                if(j == 0) return@forEachIndexed
                else if(matrix[i-1][j-1] != item) return false
            }
        }
        return true
    }
}