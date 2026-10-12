class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int half = n/2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int majority = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > half){
                majority = entry.getKey();
            }
        }
        return majority;
    }
}