import java.util.*

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequencyOfWords  = mutableMapOf<String, Int>()
        for (word in words) {
            val frequencyOfCurWord = frequencyOfWords.getOrDefault(word, 0)
            frequencyOfWords[word] = frequencyOfCurWord + 1
        }

        val pq = PriorityQueue<Pair<Int, String>> {a, b ->
            if(a.first == b.first) a.second.compareTo(b.second)
            else b.first - a.first
        }

        for (word in frequencyOfWords.keys) {
            pq.add(Pair(frequencyOfWords.getOrDefault(word, 0), word))
        }

        val answer = mutableListOf<String>()
        for (i in 1..k) {
            answer.add(pq.poll().second)
        }
        return answer
    }
}