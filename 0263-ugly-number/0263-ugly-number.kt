class Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) return false
        var num = n
        while (num > 1) {
            if (num % 2 == 0) num /= 2
            else if (num % 3 == 0) num /= 3
            else if (num % 5 == 0) num /= 5
            else return false
        }
        return true
    }
}