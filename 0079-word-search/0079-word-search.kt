enum class Dir {
    RIGHT, DOWN, LEFT, UP;

    fun dx() = listOf(1, 0, -1, 0)[ordinal]

    fun dy() = listOf(0, 1, 0, -1)[ordinal]
}

data class Cor(val y: Int, val x: Int)

class Board(val board: Array<CharArray>) {

    var word = ""

    val visited = Array(board.size) { Array(board[0].size) { false } }

    fun Cor.move(dir: Dir): Cor {
        return Cor(y + dir.dy(), x + dir.dx())
    }

    fun Cor.isOutside() = y < 0 || y > board.lastIndex || x < 0 || x > board[0].lastIndex

    fun Cor.isVisited() = visited[y][x]

    fun Cor.visit() {
        visited[y][x] = true
    }

    val Cor.char
        get() = board[y][x]

    fun isExist(word: String): Boolean {
        this.word = word
        for (y in board.indices) {
            for (x in board[0].indices) {
                if (board[y][x] != word[0]) continue

                if (dfs(Cor(y, x), 0)) return true
            }
        }
        return false
    }

    fun dfs(curCor: Cor, charIdx: Int): Boolean {
        visited[curCor.y][curCor.x] = true

        if(charIdx == word.lastIndex) return true

        for (dir in Dir.values()) {
            val nextCor = curCor.move(dir)
            if (nextCor.isOutside() || nextCor.isVisited()) continue
            if (nextCor.char != word[charIdx + 1]) continue

            if(dfs(nextCor, charIdx + 1)) return true
        }
        visited[curCor.y][curCor.x] = false

        return false
    }
}

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        return Board(board).isExist(word)
    }
}