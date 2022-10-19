import java.util.*

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequencyOfWords = calFrequency(words)
        return getTopKFrequentFrom(frequencyOfWords, k)
    }

    private fun getTopKFrequentFrom(frequencyOfWords: MutableMap<String, Int>, k: Int): MutableList<String> {
        val pq = convertMapToPriorityQueue(frequencyOfWords)
        val answer = mutableListOf<String>()
        for (i in 1..k) {
            answer.add(pq.poll().second)
        }
        return answer
    }

    private fun convertMapToPriorityQueue(frequencyOfWords: MutableMap<String, Int>): PriorityQueue<Pair<Int, String>> {
        val pq = PriorityQueue<Pair<Int, String>> { a, b ->
            if (a.first == b.first) a.second.compareTo(b.second)
            else b.first - a.first
        }
        for (word in frequencyOfWords.keys) {
            pq.add(Pair(frequencyOfWords.getOrDefault(word, 0), word))
        }
        return pq
    }

    private fun calFrequency(words: Array<String>): MutableMap<String, Int> {
        val frequencyOfWords = mutableMapOf<String, Int>()
        for (word in words) {
            val frequencyOfCurWord = frequencyOfWords.getOrDefault(word, 0)
            frequencyOfWords[word] = frequencyOfCurWord + 1
        }
        return frequencyOfWords
    }
}