class Solution {

    fun minWindow(s: String, t: String): String {
        if(s.length < t.length || s.isEmpty()) return "";

        val hashMap = mutableMapOf<Char, Int>()
        for (ch in t) {
            hashMap[ch] = hashMap.getOrDefault(ch, 0) + 1
        }

        var minLeft = 0
        var minRight = 987654321

        var left = 0
        var numOfCharInT = 0
        for (right in s.indices) {
            val curCh = s[right]
            if (!hashMap.containsKey(curCh)) continue

            // is s.substring(left, right+1) window substring?
            hashMap[curCh] = hashMap[curCh]!! - 1
            if (hashMap[curCh]!! >= 0) numOfCharInT++
            if (numOfCharInT != t.length) continue

            // find min value of left
            while (left < s.length) {
                if (!hashMap.containsKey(s[left])) {
                    left++
                    continue
                }
                if (hashMap[s[left]]!! < 0) {
                    hashMap[s[left]] = hashMap[s[left]]!! + 1
                    left++
                    continue
                }
                break;
            }

            // update minRight, minLeft
            if (minRight - minLeft > right - left) {
                minLeft = left;
                minRight = right;
            }
        }

        if (minRight == 987654321) return ""
        return s.substring(minLeft, minRight + 1)
    }
}