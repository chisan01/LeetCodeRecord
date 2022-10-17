class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] isAppear = new boolean['z' - 'a' + 1];

        int cnt = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int cur = sentence.charAt(i) - 'a';
            if(isAppear[cur]) continue;
            
            isAppear[cur] = true;
            cnt++;
        }
        return cnt == 'z' - 'a' + 1;
    }
}