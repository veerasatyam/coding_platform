class TimeMap {
     
    class Timestamp_Values {
       String value;
       int timestamp;  
       public Timestamp_Values(String value, int timestamp) {
           this.value = value;
           this.timestamp = timestamp;
       }
    }

    HashMap<String, ArrayList<Timestamp_Values>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(new Timestamp_Values(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) return "";

        ArrayList<Timestamp_Values> list = hm.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
