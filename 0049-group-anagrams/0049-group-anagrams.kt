import java.util.PriorityQueue

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val key = str.compact()
            map[key] = map.getOrDefault(key, mutableListOf()).apply { add(str) }
        }
        return map.values.toList()
    }
}

fun String.compact(): String {
    val cnts = MutableList<Int>('z' - 'a' + 1) { 0 }
    forEach { cnts[it - 'a']++ }
    return cnts.withIndex().joinToString(" ") {
        if(it.value == 0) ""
        else "" + ('a' + it.index) + it.value
    }
}