import java.util.*;

class Solution {

    int[][] dp;

    void init(String s, int k) {
        this.dp = new int[s.length() + 1][k + 1];
        for(int[] row : dp) Arrays.fill(row, 101);
        dp[0][0] = 0;
    }

    int calLenOfCompressedString(int sameCharCnt) {
        if(sameCharCnt >= 100) return 4;
        else if(sameCharCnt >= 10) return 3;
        else if(sameCharCnt > 1) return 2;
        return 1;
    }

    public int getLengthOfOptimalCompression(String s, int maxDelCnt) {
        init(s, maxDelCnt);

        for (int R = 1; R <= s.length(); R++) {
            for (int delCnt = 0; delCnt <= maxDelCnt; delCnt++) {
                // keep s[R - 1]
                int sameCharCnt = 0, differentCharCnt = 0;
                for (int L = R; L >= 1; L--) {
                    if (s.charAt(L-1) == s.charAt(R-1)) sameCharCnt++;
                    else differentCharCnt++;

                    if(differentCharCnt > delCnt) break;

                    dp[R][delCnt] = Math.min(
                            dp[R][delCnt],
                            dp[L-1][delCnt - differentCharCnt] + calLenOfCompressedString(sameCharCnt)
                    );
                }

                // delete s[R - 1]
                if(delCnt == 0) continue;
                dp[R][delCnt] = Math.min(dp[R][delCnt], dp[R - 1][delCnt - 1]);
            }
        }
        return dp[s.length()][maxDelCnt];
    }
}