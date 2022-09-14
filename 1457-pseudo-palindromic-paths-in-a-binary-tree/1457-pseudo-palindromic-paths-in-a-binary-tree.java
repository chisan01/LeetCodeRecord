class Solution {

    int[] digitCnt;

    boolean isCurPathPseudoPalindromic(int leafNodeNum) {
        digitCnt[leafNodeNum]++;
        
        int oddDigitCnt = 0, evenDigitCnt = 0, totalNumCnt = 0;
        for (int i = 1; i <= 9; i++) {
            if(digitCnt[i] == 0) continue;
            
            totalNumCnt += digitCnt[i];
            if (digitCnt[i] % 2 == 0) evenDigitCnt++;
            else oddDigitCnt++;
        }
    
        digitCnt[leafNodeNum]--;
        
        if(totalNumCnt % 2 == 1 && oddDigitCnt == 1) return true;
        if(totalNumCnt % 2 == 0 && oddDigitCnt == 0) return true;
        return false;
    }

    int search(TreeNode curNode) {
        
        // curNode is leaf node
        if (curNode.left == null && curNode.right == null) {
            if (isCurPathPseudoPalindromic(curNode.val)) return 1;
            else return 0;
        }
        
        digitCnt[curNode.val]++;

        int cnt = 0;
        if(curNode.left != null) cnt += search(curNode.left);
        if(curNode.right != null) cnt += search(curNode.right);
        
        digitCnt[curNode.val]--;
        
        return cnt;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        digitCnt = new int[10];
        Arrays.fill(digitCnt, 0);
        return search(root);
    }
}