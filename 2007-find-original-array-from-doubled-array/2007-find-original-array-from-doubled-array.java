import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[]{};

        Arrays.sort(changed);

        List<Integer> original = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int curNum : changed) {
            if (!pq.isEmpty() && pq.peek() * 2 == curNum) {
                original.add(pq.poll());
            } else {
                pq.add(curNum);
            }
        }

        if(!pq.isEmpty()) return new int[]{};
        return original.stream().mapToInt(Integer::intValue).toArray();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        br.close();
    }
}