import java.util.Arrays;

class Solution {
    public int countQuadruplets(int[] nums) {
        // Arrays.sort(nums);
        int cnt = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        int sum = nums[a] + nums[b] + nums[c];
                        if(sum == nums[d]) cnt++;
                        // else if(sum < nums[d]) break;
                    }
                }
            }
        }
        return cnt;
    }
}