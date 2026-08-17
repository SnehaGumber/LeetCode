class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int l=0, r=0, maxLen=0;
        while(r < n){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}