import java.util.*
import kotlin.math.max

data class Job(val startTime: Int, val endTime: Int, val profit: Int)

class Solution {

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = mutableListOf<Job>()
        jobs.add(Job(0, 0, 0))
        for (i in 0..startTime.lastIndex) {
            jobs.add(Job(startTime[i], endTime[i], profit[i]))
        }
        jobs.sortBy { it.endTime }

        val dp = TreeMap<Int, Int>().apply { put(0, 0) }
        for (job in jobs) {
            dp[job.endTime] = max(
                dp.floorEntry(job.startTime).value + job.profit,
                dp.lastEntry().value
            )
        }
        return dp.lastEntry().value
    }
}
