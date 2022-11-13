import java.util.*

class Solution {
    fun reverseWords(s: String): String {
        val stack = Stack<String>()
        s.split(" ")
            .filter { it != " " && it != "" }
            .forEach { stack.add(it) }

        var result = ""
        while (stack.isNotEmpty()) {
            result += stack.pop()
            if(stack.isNotEmpty()) result += " "
        }
        return result
    }
}