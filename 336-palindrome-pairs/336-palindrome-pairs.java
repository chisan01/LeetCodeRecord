class TrieNode {
    public TrieNode[] next;
    Integer wordIndex;
    List<Integer> wordIndexList;

    public TrieNode() {
        this.next = new TrieNode['z' - 'a' + 1];
        wordIndex = null;
        wordIndexList = new ArrayList<>();
    }
}

class Solution {

    TrieNode root;
    List<List<Integer>> answer;

    void addReverseWord(String word, int idxOfWord) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) cur.wordIndexList.add(idxOfWord);
            cur = cur.next[ch - 'a'];
        }
        cur.wordIndex = idxOfWord;
        cur.wordIndexList.add(idxOfWord);
    }

    void search(String word, int idxOfWord) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.wordIndex != null && cur.wordIndex != idxOfWord && isPalindrome(word, i, word.length() - 1)) {
                List<Integer> indice = List.of(idxOfWord, cur.wordIndex);
                answer.add(indice);
            }

            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null) return;
            cur = cur.next[ch - 'a'];
        }

        for (int j : cur.wordIndexList) {
            if (j == idxOfWord) continue;
            List<Integer> indice = List.of(idxOfWord, j);
            answer.add(indice);
        }
    }

    boolean isPalindrome(String word, int L, int R) {
        while (L <= R) {
            if (word.charAt(L++) != word.charAt(R--)) return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addReverseWord(words[i], i);
        }

        answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            search(words[i], i);
        }
        return answer;
    }
}