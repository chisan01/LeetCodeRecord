class Solution {

    fun minWindow(s: String, t: String): String {

        val map = mutableMapOf<Char, Int>()
        for (ch in t) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        var left = 0
        var minLeft = 0
        var minLen = s.length + 1
        var numOfCharInT = 0

        for (right in s.indices) {
            val curCh = s[right]
            if (!map.containsKey(curCh)) continue

            // is s.substring(left, right+1) window substring?
            map[curCh] = map[curCh]!! - 1
            if (map[curCh]!! >= 0) numOfCharInT++

            // find min value of left
            while (numOfCharInT == t.length) {
                // update minRight, minLeft
                if(right - left + 1 < minLen) {
                    minLeft = left
                    minLen = right - left + 1
                }
                
                if (map.containsKey(s[left])) {
                    map[s[left]] = map[s[left]]!! + 1
                    if(map[s[left]]!! > 0) {
                        numOfCharInT--
                    }
                }
                left++
            }
        }

        if (minLen > s.length) return ""
        return s.substring(minLeft, minLeft + minLen)
    }
}