class Pair{
    int num;
    int freq;

    Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) +1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.freq - b.freq
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int i = 0;
        while(pq.size() > 0){
            result[i++] = pq.poll().num;
        }

        return result;


    }
}