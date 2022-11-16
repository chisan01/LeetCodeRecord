/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1.toLong()
        var right = n.toLong()
        while (true) {
            val mid = ((left + right) / 2).toInt()
            when (guess(mid)) {
                -1 -> right = mid.toLong() - 1
                0 -> return mid
                1 -> left = mid.toLong() + 1
            }
        }
    }
}