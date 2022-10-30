import java.util.LinkedList
import java.util.Queue

const val EMPTY = 0
const val OBSTACLE = 1

enum class Dir {
    LEFT, UP, RIGHT, DOWN;

    private val dx = listOf(-1, 0, 1, 0)
    private val dy = listOf(0, 1, 0, -1)

    fun dx(): Int {
        return dx[ordinal]
    }

    fun dy(): Int {
        return dy[ordinal]
    }
}

data class Cor(val y: Int, val x: Int) {
    fun move(dir: Dir): Cor {
        val newY = y + dir.dy()
        val newX = x + dir.dx()
        return Cor(newY, newX)
    }
}

class Solution {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {

        val rowSize = grid.size
        val columnSize = grid[0].size
        val lowerRightCorner = Cor(rowSize - 1, columnSize - 1)

        val q: Queue<Triple<Cor, Int, Int>> = LinkedList()
        q.add(Triple(Cor(0, 0), k, 0))
        val isVisit = Array(k + 1) { Array(rowSize) { Array(columnSize) { false } } }

        while (!q.isEmpty()) {
            val (curCor, curK, curSteps) = q.poll()

            if (isVisit[curK][curCor.y][curCor.x]) continue
            isVisit[curK][curCor.y][curCor.x] = true

            if (curCor == lowerRightCorner) return curSteps

            for (dir in Dir.values()) {
                val nextCor = curCor.move(dir)

                if (nextCor.y < 0 || nextCor.y >= grid.size || nextCor.x < 0 || nextCor.x >= grid[0].size) continue

                if (grid[nextCor.y][nextCor.x] == OBSTACLE) {
                    if (curK <= 0) continue
                    q.add(Triple(nextCor, curK - 1, curSteps + 1))
                } else {
                    q.add(Triple(nextCor, curK, curSteps + 1))
                }
            }
        }
        return -1
    }
}