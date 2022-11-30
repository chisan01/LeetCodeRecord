import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.stream(arr).forEach(value -> map.put(value, map.getOrDefault(value, 0) + 1));

        Set<Integer> set = new HashSet<>();
        for(int cnt : map.values()) {
            if(set.contains(cnt)) return false;
            set.add(cnt);
        }
        return true;
    }
}