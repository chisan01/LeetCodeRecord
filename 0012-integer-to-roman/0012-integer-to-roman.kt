class Solution {
    fun intToRoman(num: Int): String {
        val symbolOfRoman = mapOf<Int, String>(
            Pair(1, "I"),
            Pair(5, "V"),
            Pair(10, "X"),
            Pair(50, "L"),
            Pair(100, "C"),
            Pair(500, "D"),
            Pair(1000, "M")
        )

        var result = ""
        var div = num
        
        for (i in listOf(1000, 100, 10, 1)) {

            val curDigitString = when (val digit = div / i) {
                0 -> ""
                in 1..3 -> symbolOfRoman[i]?.repeat(digit)
                4 -> symbolOfRoman[i] + symbolOfRoman[i * 5]
                in 5..8 -> symbolOfRoman[i * 5] + symbolOfRoman[i]?.repeat(digit - 5)
                9 -> symbolOfRoman[i] + symbolOfRoman[i * 10]
                else -> ""
            }

            result += curDigitString
            div %= i
        }
        
        return result
    }
}