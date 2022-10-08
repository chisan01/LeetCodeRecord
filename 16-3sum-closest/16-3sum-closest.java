import java.io.*;
import java.util.*;

class Solution {

    int target;
    int[] nums;
    int closestSumToTarget;

    public void search(int i) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            int curSum = nums[i] + nums[j] + nums[k];
            if (Math.abs(target - curSum) < Math.abs(target - closestSumToTarget)) {
                closestSumToTarget = curSum;
            }
            if(curSum > target) k--;
            else j++;
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        closestSumToTarget = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) search(i);
        
        return closestSumToTarget;
    }
}