class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> valuesOfKey;

    public TimeMap() {
        valuesOfKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!valuesOfKey.containsKey(key)) valuesOfKey.put(key, new TreeMap<>());
        this.valuesOfKey.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!valuesOfKey.containsKey(key)) return "";

        TreeMap<Integer, String> treeMap = this.valuesOfKey.get(key);

        Integer floor = treeMap.floorKey(timestamp);
        
        if(floor == null) return "";

        return treeMap.get(floor);
    }
}