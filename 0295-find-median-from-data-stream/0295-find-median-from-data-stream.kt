import java.util.*

class MedianFinder() {

    private val frontQueue = PriorityQueue<Int>() { a, b -> b - a }
    private val backQueue = PriorityQueue<Int>() { a, b -> a - b }

    fun addNum(num: Int) {
        if(frontQueue.isNotEmpty() && frontQueue.peek() < num) backQueue.add(num)
        else frontQueue.add(num)

        if(frontQueue.size > backQueue.size) backQueue.add(frontQueue.poll())
        if(frontQueue.size < backQueue.size) frontQueue.add(backQueue.poll())
    }

    fun findMedian(): Double {
        return if(frontQueue.size == backQueue.size) (frontQueue.peek() + backQueue.peek()) / 2.0
        else if(frontQueue.size > backQueue.size) frontQueue.peek().toDouble()
        else backQueue.peek().toDouble()
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */