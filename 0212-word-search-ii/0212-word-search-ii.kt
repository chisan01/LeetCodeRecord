class TrieNode(
    val next: Array<TrieNode?> = Array(26) { null },
    var word: String? = null
)

private fun createTrieFrom(words: Array<String>): TrieNode {
    val root = TrieNode()
    for (w in words) {
        var p = root
        for (c in w) {
            val i = c - 'a'
            if (p.next[i] == null) p.next[i] = TrieNode()
            p = p.next[i]!!
        }
        p.word = w
    }
    return root
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val res = mutableSetOf<String>()
        val root = createTrieFrom(words)

        for (y in board.indices) {
            for (x in board[0].indices) {
                dfs(board, y, x, root, res)
            }
        }
        return res.toList()
    }

    private fun dfs(board: Array<CharArray>, y: Int, x: Int, p: TrieNode, res: MutableSet<String>) {
        val curChar = board[y][x]

        if (curChar == '#' || p.next[curChar - 'a'] == null) return
        val nextP = p.next[curChar - 'a']!!

        nextP.word?.let { res.add(it) }

        val dy = listOf(0, 1, 0, -1)
        val dx = listOf(-1, 0, 1, 0)

        board[y][x] = '#'
        repeat(4) {
            val nextY = y + dy[it]
            val nextX = x + dx[it]

            if (nextY < 0 || nextY > board.lastIndex || nextX < 0 || nextX > board[0].lastIndex) return@repeat

            dfs(board, nextY, nextX, nextP, res)
        }
        board[y][x] = curChar
    }
}

