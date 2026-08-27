class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer>map = new TreeMap<>();
        if(hand.length % groupSize != 0) return false;
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0)+1);
        }
        while(!map.isEmpty()){
            int smallest = map.firstKey();
            for(int i=0; i<groupSize; i++){
                int need = smallest + i;
                if(!map.containsKey(need)){
                    return false;
                }
                int freq = map.get(need);
                if(freq == 1) map.remove(need);
                else map.put(need, freq-1);
            }
            
        }
        return true;
    }
}