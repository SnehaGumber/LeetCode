class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(!map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
                r++;
            }else{
                while(map.containsKey(ch)){
                    l++;
                    map.put(s.charAt(l-1), map.get(s.charAt(l-1))-1);
                    if(map.get(s.charAt(l-1)) == 0){
                        map.remove(s.charAt(l-1));
                    }
                }
                
            }
            int len = r - l;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}