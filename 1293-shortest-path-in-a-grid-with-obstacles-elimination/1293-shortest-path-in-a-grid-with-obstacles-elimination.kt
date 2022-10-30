import java.util.LinkedList
import java.util.Queue

const val EMPTY = 0
const val OBSTACLE = 1

class Solution {

    data class Node(val y: Int, val x: Int, val leftK: Int, val curSteps: Int)

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {

        val rowSize = grid.size
        val columnSize = grid[0].size

        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val q = LinkedList<Node>()
        q.offer(Node(0, 0, k, 0))

        val isVisit = Array(k + 1) { Array(rowSize) { BooleanArray(columnSize) } }

        while (q.isNotEmpty()) {
            val (curY, curX, curLeftK, curSteps) = q.poll()

            if (isVisit[curLeftK][curY][curX]) continue
            isVisit[curLeftK][curY][curX] = true

            if (curY == rowSize - 1 && curX == columnSize - 1) return curSteps

            dirs.forEach { dir ->
                val y = curY + dir[0]
                val x = curX + dir[1]

                if (y < 0 || y >= grid.size || x < 0 || x >= grid[0].size) return@forEach
                if (isVisit[curLeftK][y][x]) return@forEach

                if (grid[y][x] == OBSTACLE && curLeftK > 0) {
                    q.offer(Node(y, x, curLeftK - 1, curSteps + 1))
                } else if (grid[y][x] == EMPTY) {
                    q.offer(Node(y, x, curLeftK, curSteps + 1))
                }
            }
        }
        return -1
    }
}