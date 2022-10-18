class Solution {

    fun countAndSay(string: String): String {
        var cnt: Int = 0
        var curChar: Char = string[0]
        
        var ret: String = ""
        for (ch in string) {
            if(ch == curChar) cnt++
            else {
                ret += cnt.toString() + curChar
                cnt = 1
                curChar = ch
            }
        }
        ret += cnt.toString() + curChar
        
        return ret
    }
    
    fun countAndSay(n: Int): String {
        var ans: String = "1"

        for (i in 1..n-1) {
            ans = countAndSay(ans)
        }
        
        return ans
    }
}