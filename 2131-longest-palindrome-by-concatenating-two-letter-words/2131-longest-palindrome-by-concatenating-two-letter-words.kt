class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        var result = if (words
                .filter { it[0] == it[1] }
                .groupBy { it[0] }
                .filter { it.value.size % 2 == 1 }
                .isNotEmpty()
        ) 2 else 0

        val map = mutableMapOf<Int, Int>()

        words
            .forEach { 
                val key = (it[0] - 'a') * 100 + (it[1] - 'a')
                val reverseKey = (it[1] - 'a') * 100 + (it[0] - 'a')
                
                if((map[reverseKey] ?: 0) > 0) {
                    map[reverseKey] = map[reverseKey]!! - 1
                    result += 4
                }
                else map[key] = map.getOrDefault(key, 0) + 1
            }

        return result
    }
}