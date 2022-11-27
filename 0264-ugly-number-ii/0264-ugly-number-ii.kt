import java.util.PriorityQueue

class Solution {

    fun nthUglyNumber(n: Int): Int {

        val pq = PriorityQueue<Long> { a, b -> a.compareTo(b) }
        pq.add(1)

        val uglyNumbers = mutableSetOf<Long>(1)

        var uglyNumberCnt = 0
        while (true) {
            uglyNumberCnt++
            val curUglyNumber = pq.poll()

            if(uglyNumberCnt == n) return curUglyNumber.toInt()

            if(!uglyNumbers.contains(curUglyNumber * 2)) {
                uglyNumbers.add(curUglyNumber * 2)
                pq.add(curUglyNumber * 2)
            }
            if(!uglyNumbers.contains(curUglyNumber * 3)) {
                uglyNumbers.add(curUglyNumber * 3)
                pq.add(curUglyNumber * 3)
            }
            if(!uglyNumbers.contains(curUglyNumber * 5)) {
                uglyNumbers.add(curUglyNumber * 5)
                pq.add(curUglyNumber * 5)
            }
        }
    }
}