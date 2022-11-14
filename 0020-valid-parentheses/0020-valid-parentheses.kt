import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val openBrackets = listOf('(', '[', '{')
        val closeBrackets = listOf(')', ']', '}')

        val stack = Stack<Char>()
        s
            .filter { openBrackets.contains(it) || closeBrackets.contains(it) }
            .forEach {
                if(stack.isNotEmpty()
                    && openBrackets.contains(stack.peek())
                    && closeBrackets.contains(it)
                    && openBrackets.indexOf(stack.peek()) == closeBrackets.indexOf(it)
                ) stack.pop()
                else stack.add(it)
            }
        return stack.isEmpty()
    }
}