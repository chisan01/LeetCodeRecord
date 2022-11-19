import java.util.PriorityQueue

class Solution {

    private fun ccw(p1: IntArray, p2: IntArray, p3: IntArray): Int {
        val (x1, y1) = p1
        val (x2, y2) = p2
        val (x3, y3) = p3
        return (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2)
    }

    fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
        val pq = PriorityQueue<IntArray> { a, b ->
            val (x1, y1) = a
            val (x2, y2) = b
            if (x1 == x2) y1 - y2 else x1 - x2
        }
        trees.forEach { pq.add(it) }

        val lower = mutableListOf<IntArray>()
        val upper = mutableListOf<IntArray>()

        while (pq.isNotEmpty()) {
            val curPoint = pq.poll()
            while (upper.size >= 2 && ccw(upper[upper.lastIndex - 1], upper[upper.lastIndex], curPoint) > 0) {
                upper.removeAt(upper.lastIndex)
            }
            upper.add(curPoint)
            while (lower.size >= 2 && ccw(lower[lower.lastIndex - 1], lower[lower.lastIndex], curPoint) < 0) {
                lower.removeAt(lower.lastIndex)
            }
            lower.add(curPoint)
        }
        return (lower + upper).distinct().toTypedArray()
    }
}