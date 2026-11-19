class Pair{
    int timestamp;
    String value;
    Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(timestamp, value));
        }else{
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int low = 0;

        int high = list.size() - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid).timestamp <= timestamp){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(ans == -1) return "";
        return list.get(ans).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */