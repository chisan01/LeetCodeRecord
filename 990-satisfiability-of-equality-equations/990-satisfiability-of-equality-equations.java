class Pair {
    public int item1, item2;

    public Pair(int item1, int item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
}

class Solution {

    int[] parents;

    List<Pair> notEqualRelations = new ArrayList<>();

    void init() {
        parents = new int['z' - 'a' + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    int groupOf(int node) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    void mergeGroup(int group1, int group2) {
        parents[group1] = group2;
    }

    boolean checkPossibility() {
        for (Pair relation : notEqualRelations) {
            if(groupOf(relation.item1) == groupOf(relation.item2)) return false;
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {

        init();

        for (String equation : equations) {
            int group1 = groupOf(equation.charAt(0) - 'a');
            int group2 = groupOf(equation.charAt(3) - 'a');

            if (equation.charAt(1) == '!') {
                notEqualRelations.add(new Pair(group1, group2));
                if(!checkPossibility()) return false;
            } else {
                mergeGroup(group1, group2);
                if(!checkPossibility()) return false;
            }
        }
        return true;
    }
}