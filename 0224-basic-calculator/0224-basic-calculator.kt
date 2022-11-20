import java.util.*

class Solution {

    private val queue = LinkedList<String>()

    private fun resultInGroup(): Int {
        var result = 0
        var isPlus = true
        while (queue.isNotEmpty()) {
            when (val cur = queue.poll()) {
                "+" -> isPlus = true
                "-" -> isPlus = false
                "(" -> {
                    if(isPlus) result += resultInGroup()
                    else result -= resultInGroup()
                }
                ")" -> return result
                else -> {
                    if(isPlus) result += cur.toInt()
                    else result -= cur.toInt()
                }
            }
        }
        return result
    }

    fun calculate(s: String): Int {
        var curNum = ""
        s
            .filter { it != ' ' }
            .forEach { 
                if(it in '0'..'9') curNum += it
                else {
                    if(curNum != "") {
                        queue.add(curNum)
                        curNum = ""
                    }
                    queue.add(it.toString())
                }
            }
        if(curNum != "") queue.add(curNum)
        
        queue.forEach(::println)
        return resultInGroup()
    }
}