import kotlin.math.max

class Solution {

    private fun isDuplicate(str: String): Boolean {
        return str.chars().distinct().toArray().size != str.length
    }

    private fun recur(arr: List<String>, i: Int, concatString: String): Int {
        if(i == arr.size) return concatString.length

        val curString = arr[i]
        
        val resultWhenNotConcatCurString = recur(arr, i + 1, concatString)
        if(isDuplicate(concatString + curString)) return resultWhenNotConcatCurString

        val resultWhenConcatCurString = recur(arr, i + 1, concatString + curString)
        return max(resultWhenNotConcatCurString, resultWhenConcatCurString)
    }

    fun maxLength(arr: List<String>): Int {
        return recur(arr, 0, "")
    }
}