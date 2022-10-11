import java.util.*;

class Solution {

    public boolean increasingTriplet(int[] nums) {
        
        List<Integer> longestIncreaseSubarray = new ArrayList<>();
        longestIncreaseSubarray.add(nums[0]);
        
        for (int curNum : nums) {
            if (curNum > longestIncreaseSubarray.get(longestIncreaseSubarray.size() - 1)) {
                longestIncreaseSubarray.add(curNum);
            } else {
                for (int j = 0; j < longestIncreaseSubarray.size(); j++) {
                    if (curNum > longestIncreaseSubarray.get(j)) continue;
                    if (curNum == longestIncreaseSubarray.get(j)) break;

                    longestIncreaseSubarray.set(j, curNum);
                    break;
                }
            }
            
            // longestIncreaseSubarray.forEach(a -> System.out.print(a + " "));
            // System.out.println();

            if (longestIncreaseSubarray.size() >= 3) {
                return true;
            }
        }
        return false;
    }
}