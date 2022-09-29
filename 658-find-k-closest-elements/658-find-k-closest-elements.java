class Node implements Comparable<Node> {
    public int diff, pos;

    public Node(int diff, int pos) {
        this.diff = diff;
        this.pos = pos;
    }

    @Override
    public int compareTo(Node o) {
        if(o.diff == this.diff) return this.pos - o.pos;
        else return this.diff - o.diff;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Node(Math.abs(x - arr[i]), i));
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(pq.isEmpty()) break;
            ret.add(arr[pq.poll().pos]);
        }
        ret.sort((a, b) -> a - b);
        return ret;
    }
}