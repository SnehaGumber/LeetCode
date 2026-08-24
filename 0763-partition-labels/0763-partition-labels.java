class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastOcc = new int[26];
        int n = s.length();
        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            lastOcc[ch-'a'] = i;
        }
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            end = Math.max(lastOcc[curr-'a'], end);
            if(i == end){
                ans.add(end-start+1);
                start = end + 1;
            }
        }
        
        return ans;
    }
}