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

class Cor(val y: Int, val x: Int) {
    fun move(dir: Dir): Cor {
        val newY = y + dir.dy()
        val newX = x + dir.dx()
        return Cor(newY, newX)
    }

    override fun equals(other: Any?): Boolean {
        if (other is Cor) return this.x == other.x && this.y == other.y
        return false
    }

    override fun toString(): String {
        return "Cor(x=$x, y=$y)"
    }
}

class Grid(private val grid: Array<IntArray>, private val k: Int) {

    private val rowSize = grid.size
    private val columnSize = grid[0].size

    private val lowerRightCorner = Cor(rowSize - 1, columnSize - 1)

    // dp[leftK][x][y]
    private val dp = MutableList(k + 1) { MutableList(grid.size) { MutableList(grid[0].size) { -1 } } }

    private fun Cor.isOutside(): Boolean {
        return this.y < 0 || this.y >= grid.size || this.x < 0 || this.x >= grid[0].size
    }

    fun shortestPath(): Int {
        val q: Queue<Triple<Cor, Int, Int>> = LinkedList()
        q.add(Triple(Cor(0, 0), this.k, 0))
        val isVisit = Array(this.k + 1) { Array(rowSize) { Array(columnSize) { false } } }

        while (!q.isEmpty()) {
            val (curCor, curK, curSteps) = q.poll()

            if (isVisit[curK][curCor.y][curCor.x]) continue
            isVisit[curK][curCor.y][curCor.x] = true

            if (curCor == lowerRightCorner) return curSteps

            for (dir in Dir.values()) {
                val nextCor = curCor.move(dir)

                if (nextCor.isOutside()) continue

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

class Solution {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val myGrid = Grid(grid, k)
        return myGrid.shortestPath()
    }
}