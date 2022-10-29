import java.util.PriorityQueue
import kotlin.math.max

class Solution {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
        
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> {a, b -> b.second - a.second})
        for (i in plantTime.indices) {
            pq.add(Pair(plantTime[i], growTime[i]))
        }
        
        var lastDayOfBloom = 0
        var curDay = 0
        while (!pq.isEmpty()) {
            val poll = pq.poll()
            curDay += poll.first
            lastDayOfBloom = max(lastDayOfBloom, curDay + poll.second)
        }
        
        return lastDayOfBloom
    }
}