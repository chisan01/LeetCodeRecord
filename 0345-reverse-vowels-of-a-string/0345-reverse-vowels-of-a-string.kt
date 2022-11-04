import java.util.*

class Solution {

    private fun Char.isVowels(): Boolean {
        val ch = this.toLowerCase()
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
    }

    fun reverseVowels(s: String): String {
        val stack = Stack<Char>()

        s
            .filter { it.isVowels() }
            .forEach { stack.push(it) }

        return s
            .map {
                if (it.isVowels()) stack.pop()
                else it
            }
            .joinToString("")
    }
}