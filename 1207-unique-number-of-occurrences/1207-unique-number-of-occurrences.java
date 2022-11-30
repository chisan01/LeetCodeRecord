import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.stream(arr).forEach(value -> map.put(value, map.getOrDefault(value, 0) + 1));
        return map.values().stream().distinct().count() == map.values().size();
    }
}