import java.util.PriorityQueue

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val pq = PriorityQueue<Pair<String, Int>>(compareBy { it.first })
        for (i in strs.indices) {
            pq.add(strs[i].compact() to i)
        }

        val result = mutableListOf<List<String>>()
        val group = mutableListOf<String>()
        var curStr: String? = null
        while (!pq.isEmpty()) {
            val curPair = pq.poll()
            if (group.isNotEmpty() && !curStr.equals(curPair.first)) {
                result.add(group.toList())
                group.clear()
            }

            group.add(strs[curPair.second])
            curStr = curPair.first
        }
        if(group.isNotEmpty()) result.add(group.toList())
        return result
    }
}

fun String.compact(): String {
    val cnts = MutableList<Int>('z' - 'a' + 1) { 0 }
    forEach { cnts[it - 'a']++ }
    return cnts.withIndex().joinToString("") {
        if(it.value == 0) ""
        else "" + ('a' + it.index) + it.value
    }
}