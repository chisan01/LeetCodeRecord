class Edge {
    public int height, blockIdx, xCor;

    public Edge(int height, int blockIdx, int xCor) {
        this.height = height;
        this.blockIdx = blockIdx;
        this.xCor = xCor;
    }
}

class Solution {

    final int HAS_STARTED = 1, IS_REMOVED = 2;

    public List<List<Integer>> getSkyline(int[][] buildings) {

        PriorityQueue<Edge> edges = new PriorityQueue<>((a, b) -> a.xCor - b.xCor);
        for (int i = 0; i < buildings.length; i++) {
            int leftXCor = buildings[i][0], rightXCor = buildings[i][1], height = buildings[i][2];
            edges.add(new Edge(height, i, leftXCor));
            edges.add(new Edge(height, i, rightXCor));
        }

        PriorityQueue<Edge> heightCandidates = new PriorityQueue<>((a, b) -> b.height - a.height);
        int[] statusOfBlocks = new int[buildings.length];
        int curH = 0;
        List<List<Integer>> answer = new ArrayList<>();
        Stack<List<Integer>> tempAnswer = new Stack<>();

        while (!edges.isEmpty()) {
            Edge curEdge = edges.poll();
            statusOfBlocks[curEdge.blockIdx]++;
            heightCandidates.add(curEdge);

            while (!edges.isEmpty() && edges.peek().xCor == curEdge.xCor) {
                statusOfBlocks[edges.peek().blockIdx]++;
                heightCandidates.add(edges.peek());
                
                if(edges.peek().height > curEdge.height) curEdge = edges.poll();
                else edges.poll();
            }

            if(curEdge.height < curH) continue;

            while(!heightCandidates.isEmpty()) {
                Edge nextEdge = heightCandidates.peek();
                if(statusOfBlocks[nextEdge.blockIdx] != IS_REMOVED) {
                    curH = nextEdge.height;
                    break;
                }
                heightCandidates.poll();
            }
            if(heightCandidates.isEmpty() || edges.isEmpty()) curH = 0;

            if(curH == 0 && !edges.isEmpty() && edges.peek().xCor == curEdge.xCor) curH = edges.poll().height;

            if(tempAnswer.isEmpty()) tempAnswer.add(List.of(curEdge.xCor, curH));
            else if(tempAnswer.peek().get(1) == curH) {
                if(tempAnswer.size() == 2) tempAnswer.pop();
                tempAnswer.add(List.of(curEdge.xCor, curH));
            } else {
                if(tempAnswer.size() == 2) tempAnswer.pop();
                answer.add(tempAnswer.pop());
                tempAnswer = new Stack<>();
                tempAnswer.add(List.of(curEdge.xCor, curH));
            }
        }

        answer.addAll(tempAnswer);

        return answer;
    }
}