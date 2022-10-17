class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        for(alphabet in 'a'..'z') {
            if(!sentence.contains(alphabet)) return false;
        }
        return true;
    }
}