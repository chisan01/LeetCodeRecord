import java.util.*;

class Solution {

    public boolean increasingTriplet(int[] nums) {
        
        List<Integer> longestIncreaseSubarray = new ArrayList<>();
        longestIncreaseSubarray.add(nums[0]);
        
        for (int curNum : nums) {
            if (curNum > longestIncreaseSubarray.get(longestIncreaseSubarray.size() - 1)) {
                longestIncreaseSubarray.add(curNum);
            } else {
                int L = 0, R = longestIncreaseSubarray.size() - 1;
                while(L < R) {
                    int mid = (L+R)/2;
                    if(curNum > longestIncreaseSubarray.get(mid)) L = mid + 1;
                    else R = mid;
                }
                
                if(longestIncreaseSubarray.get(L) <= curNum) continue;
                longestIncreaseSubarray.set(L, curNum);
            }
            
            if (longestIncreaseSubarray.size() >= 3) {
                return true;
            }
        }
        return false;
    }
}