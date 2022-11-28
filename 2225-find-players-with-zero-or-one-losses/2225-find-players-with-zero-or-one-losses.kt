class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val lossCnt = mutableMapOf<Int, Int>()

        for (match in matches) {
            val winner = match[0]
            val looser = match[1]

            if (!lossCnt.containsKey(winner)) lossCnt[winner] = 0
            lossCnt[looser] = lossCnt.getOrDefault(looser, 0) + 1
        }

        val ret = List(2) { (mutableListOf<Int>()) }
        for (people in lossCnt.keys) {
            if (lossCnt[people] == 0) ret[0].add(people)
            if (lossCnt[people] == 1) ret[1].add(people)
        }
        for(list in ret) list.sort()
        return ret
    }
}