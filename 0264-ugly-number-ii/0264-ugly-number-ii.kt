import java.util.PriorityQueue

class Solution {

    fun nthUglyNumber(n: Int): Int {
        
        val primeFactors = listOf(2, 3, 5)

        val uglyNumbers = mutableSetOf<Long>()
            .apply { add(1) }
        
        val pq = PriorityQueue<Long> { a, b -> a.compareTo(b) }
            .apply { add(1) }

        var uglyNumberCnt = 0
        while (true) {
            uglyNumberCnt++
            val curUglyNumber = pq.poll()

            if(uglyNumberCnt == n) return curUglyNumber.toInt()

            for (primeFactor in primeFactors) {
                val newUglyNumber = curUglyNumber * primeFactor
                if(uglyNumbers.contains(newUglyNumber)) continue
                uglyNumbers.add(newUglyNumber)
                pq.add(newUglyNumber)
            }
        }
    }
}