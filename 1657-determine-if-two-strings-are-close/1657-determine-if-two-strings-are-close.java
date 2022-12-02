import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private void inspect(String word, ArrayList<Integer> cntOfAlphabetsInWord, Set<Character> alphabetsInWord) {
        HashMap<Character, Integer> map = new HashMap<>();
        word.chars().mapToObj(it -> (char) it).forEach(it -> map.put(it, map.getOrDefault(it, 0) + 1));
        cntOfAlphabetsInWord.addAll(map.values());
        cntOfAlphabetsInWord.sort((a, b) -> a - b);
        alphabetsInWord.addAll(map.keySet());
    }
    
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        ArrayList<Integer> alphabetCntOfWord1 = new ArrayList<>(), alphabetCntOfWord2 = new ArrayList<>();
        Set<Character> alphabetsInWord1 = new HashSet<>(), alphabetsInWord2 = new HashSet<>();
        inspect(word1, alphabetCntOfWord1, alphabetsInWord1);
        inspect(word2, alphabetCntOfWord2, alphabetsInWord2);
        return alphabetCntOfWord1.equals(alphabetCntOfWord2) && alphabetsInWord1.equals(alphabetsInWord2);
    }
}