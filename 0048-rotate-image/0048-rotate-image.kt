class Solution {

    private fun rotate(matrix: Array<IntArray>, i: Int, j: Int) {
        val n = matrix.size

        val oldValues = listOf(
            matrix[i][j],
            matrix[j][n - 1 - i],
            matrix[n - 1 - i][n - 1 - j],
            matrix[n - 1 - j][i]
        )

        matrix[i][j] = oldValues[3]
        matrix[j][n - 1 - i] = oldValues[0]
        matrix[n - 1 - i][n - 1 - j] = oldValues[1]
        matrix[n - 1 - j][i] = oldValues[2]
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in 0..(matrix.size - 1) / 2) {
            for (j in 0 until matrix.size / 2) {
                this.rotate(matrix, i, j)
            }
        }
    }
}