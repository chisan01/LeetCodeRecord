class Solution {
    
    public int findLength(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        int maxLenOfSubArray = 0;
        
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    if(i==0 || j==0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j-1] + 1;
                    maxLenOfSubArray = Math.max(maxLenOfSubArray, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        
        return maxLenOfSubArray;
    }
}