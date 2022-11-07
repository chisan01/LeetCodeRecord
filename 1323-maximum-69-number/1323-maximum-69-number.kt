class Solution {
    fun maximum69Number (num: Int): Int {
        var isNotChanged = true
        return num
            .toString().toCharArray()
            .map { 
                if(it == '6' && isNotChanged) {
                    isNotChanged = false
                    '9'
                }
                else it
            }
            .joinToString("").toInt()
    }
}