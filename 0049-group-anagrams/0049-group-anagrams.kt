import java.util.PriorityQueue

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        strs.forEach {
            val key = it.compact()
            map[key] = map.getOrDefault(key, mutableListOf()).apply { add(it) }
        }
        return map.values.toList()
    }
}

fun String.compact(): String {
    return toCharArray().sortedArray().joinToString("")
}