data class Ball(val y: Int, val x: Int, val isInDownside: Boolean = false)

class Solution {
    private fun Ball.canMove(grid: Array<IntArray>): Boolean {
        if (isInDownside) return true

        val nextX = x + grid[y][x]
        // meet wall
        if(nextX < 0 || nextX > grid[0].lastIndex) return false
        // hits a "V" shaped pattern
        if(grid[y][x] != grid[y][nextX]) return false
        return true
    }

    private fun Ball.move(grid: Array<IntArray>): Ball {
        if (isInDownside) return Ball(y + 1, x, false)
        return Ball(y, x + grid[y][x], true)
    }

    private fun run(grid: Array<IntArray>, ball: Ball): Int {
        if (ball.y == grid.lastIndex && ball.isInDownside) return ball.x
        if (!ball.canMove(grid)) return -1
        return run(grid, ball.move(grid))
    }

    fun findBall(grid: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        for (startX in grid[0].indices) {
            answer.add(run(grid, Ball(0, startX, false)))
        }
        return answer.toIntArray()
    }
}