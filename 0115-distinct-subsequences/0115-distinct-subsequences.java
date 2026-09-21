class Solution {
    public int solve(int i, int j, int[][] dp, String s, String t){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            int pick = solve(i+1, j+1, dp, s, t);
            int skip = solve(i+1, j, dp, s, t);
            dp[i][j] = pick + skip;
        }else{
            dp[i][j] = solve(i+1, j, dp, s, t);
        }
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<=s.length(); i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, dp, s, t);
    }
}