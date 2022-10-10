import java.util.*;

class Solution {

    final int NOT_FOUND = -1;

    public String breakPalindrome(String palindrome) {
        if(palindrome.length() < 2) return "";

        int firstIdxOfCharNotA = NOT_FOUND;
        for (int i = 0; i < palindrome.length()/2; i++) {
            if(palindrome.charAt(i) == 'a') continue;
            firstIdxOfCharNotA = i;
            break;
        }

        if(firstIdxOfCharNotA != NOT_FOUND) {
            return palindrome.substring(0, firstIdxOfCharNotA) + "a" + palindrome.substring(firstIdxOfCharNotA + 1);
        }

        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }
}