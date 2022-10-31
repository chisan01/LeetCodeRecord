import java.util.*

class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val linkedList = LinkedList<Int>()
        matrix[0].forEach { linkedList.add(it) }
        for(i in 1..matrix.lastIndex) {
            matrix[i].forEachIndexed { j, item ->
                if(j == 0) linkedList.addFirst(item)
                else if(linkedList[j] != item) return false
            }
            linkedList.removeLast()
        }
        return true
    }
}