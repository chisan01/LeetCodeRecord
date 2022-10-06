class TimeMap {

    private class ValueWithTimestamp {
        public String value;
        int timestamp;

        public ValueWithTimestamp(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<ValueWithTimestamp>> valuesOfKey;

    public TimeMap() {
        valuesOfKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<ValueWithTimestamp> values = this.valuesOfKey.getOrDefault(key, new ArrayList<>());
        values.add(new ValueWithTimestamp(value, timestamp));
        valuesOfKey.put(key, values);
    }

    public String get(String key, int timestamp) {
        if(!valuesOfKey.containsKey(key)) return "";

        List<ValueWithTimestamp> values = this.valuesOfKey.get(key);

        if(values.get(0).timestamp > timestamp) return "";

        int L = 0, R = values.size() - 1;
        while(L < R) {
            int mid = (L + R + 1) / 2;
            if(values.get(mid).timestamp <= timestamp) L = mid;
            else R = mid - 1;
        }

        return values.get(R).value;
    }
}