class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);
        return calNumOfVowels(a) == calNumOfVowels(b);
    }

    public int calNumOfVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        return (int) s.chars().mapToObj(a -> (char) a).filter(vowels::contains).count();
    }
}