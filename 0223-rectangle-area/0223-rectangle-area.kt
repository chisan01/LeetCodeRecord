import kotlin.math.max
import kotlin.math.min

data class Cor(val x: Int, val y: Int)

data class Rectangle(val bottomLeftCorner: Cor, val topRightCorner: Cor)

class Solution {

    private val Rectangle.size: Int
        get() = (topRightCorner.y - bottomLeftCorner.y) * (topRightCorner.x - bottomLeftCorner.x)

    private fun Rectangle.isOverlapWith(other: Rectangle): Boolean {
        return bottomLeftCorner.y >= other.topRightCorner.y
                || other.bottomLeftCorner.y >= topRightCorner.y
                || bottomLeftCorner.x >= other.topRightCorner.x
                || other.bottomLeftCorner.x >= topRightCorner.x
    }

    private fun Rectangle.sizeOfOverlapWith(other: Rectangle): Int {
        if (isOverlapWith(other)) return 0
        val lenOfX = min(topRightCorner.x, other.topRightCorner.x) - max(bottomLeftCorner.x, other.bottomLeftCorner.x)
        val lenOfY = min(topRightCorner.y, other.topRightCorner.y) - max(bottomLeftCorner.y, other.bottomLeftCorner.y)
        return lenOfX * lenOfY
    }

    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val rectangle1 = Rectangle(Cor(ax1, ay1), Cor(ax2, ay2))
        val rectangle2 = Rectangle(Cor(bx1, by1), Cor(bx2, by2))
        return rectangle1.size + rectangle2.size - rectangle1.sizeOfOverlapWith(rectangle2)
    }
}