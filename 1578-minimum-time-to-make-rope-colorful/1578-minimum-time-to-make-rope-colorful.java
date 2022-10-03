class Solution {
    public int minCost(String colors, int[] neededTime) {

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        char prevColor = colors.charAt(0);
        pq.add(neededTime[0]);
        
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) != prevColor) {
                prevColor = colors.charAt(i);
                while (pq.size() > 1) {
                    answer += pq.poll();
                }
                pq = new PriorityQueue<>();
            }
            pq.add(neededTime[i]);
        }
        while (pq.size() > 1) {
            answer += pq.poll();
        }

        return answer;
    }
}