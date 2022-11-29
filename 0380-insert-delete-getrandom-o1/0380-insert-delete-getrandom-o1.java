class RandomizedSet {
    
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int[] arr = set.stream().mapToInt(a -> a).toArray();
        return arr[(int) (Math.random() * arr.length)];
    }
}
