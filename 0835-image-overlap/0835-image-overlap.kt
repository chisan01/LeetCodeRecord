import kotlin.math.max

class Image(private val matrix: Array<IntArray>) {

    private val n = matrix.size

    fun slidingLeft(dist: Int): Image {
        val newMatrix = Array<IntArray>(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            for (j in dist until n) {
                newMatrix[i][j - dist] = matrix[i][j]
            }
        }
        return Image(newMatrix)
    }

    fun slidingRight(dist: Int): Image {
        val newMatrix = Array<IntArray>(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            for (j in dist until n) {
                newMatrix[i][j] = matrix[i][j - dist]
            }
        }
        return Image(newMatrix)
    }

    fun slidingUp(dist: Int): Image {
        val newMatrix = Array<IntArray>(n) { IntArray(n) { 0 } }
        for (i in dist until n) {
            for (j in 0 until n) {
                newMatrix[i][j] = matrix[i - dist][j]
            }
        }
        return Image(newMatrix)
    }

    fun slidingDown(dist: Int): Image {
        val newMatrix = Array<IntArray>(n) { IntArray(n) { 0 } }
        for (i in dist until n) {
            for (j in 0 until n) {
                newMatrix[i - dist][j] = matrix[i][j]
            }
        }
        return Image(newMatrix)
    }

    fun overlap(other: Image): Int {
        var cnt = 0
        for (i in this.matrix.indices) {
            for (j in this.matrix[0].indices) {
                if (this.matrix[i][j] == 1 && other.matrix[i][j] == 1) cnt++
            }
        }
        return cnt
    }

    override fun toString(): String {
        return matrix.joinToString("\n") { it.joinToString(" ") } + "\n"
    }
}

class Solution {
    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        var result = 0
        val n = img1.size
        val image1 = Image(img1)
        val image2 = Image(img2)

        for (i in 0 until n) {
            val slidingDown = image1.slidingDown(i)
            // println("slidingDown $i: \n$slidingDown")
            val slidingUp = image1.slidingUp(i)
            // println("slidingUp $i: \n$slidingUp")
            for (j in 0 until n) {
                result = max(result, slidingDown.slidingLeft(j).overlap(image2))
                result = max(result, slidingDown.slidingRight(j).overlap(image2))
                result = max(result, slidingUp.slidingLeft(j).overlap(image2))
                result = max(result, image1.slidingUp(i).slidingRight(j).overlap(image2))
            }
        }
        return result
    }
}