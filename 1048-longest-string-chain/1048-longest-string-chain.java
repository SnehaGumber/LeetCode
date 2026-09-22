class Solution {
    public int solve(int i, int[] dp, String[] words){
        int ans = 1;
        if(dp[i] != -1) return dp[i];
        for(int j=0; j<i; j++){
            if(words[i].length() == words[j].length()+1){
                int l = 0, r = 0;
                while(l < words[i].length() && r < words[j].length()){
                    if(words[i].charAt(l) == words[j].charAt(r)){
                        l++;
                        r++;
                    }else{
                        l++;
                    }
                }
                if(r == words[j].length()){
                    ans= Math.max(ans, solve(j, dp, words)+1);
                }
            }  
        }
        dp[i] = ans;
        return dp[i];
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        for(int i=0; i<words.length; i++){
            dp[i] = -1;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<words.length; i++){
            ans = Math.max(ans, solve(i, dp, words));
        }
        return ans;
        
    }
}