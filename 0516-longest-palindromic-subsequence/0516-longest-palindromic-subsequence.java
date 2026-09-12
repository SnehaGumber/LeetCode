class Solution {
    public int LPS(int i, int j, int[][] dp, String s){
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + LPS(i+1, j-1, dp, s);
        else{
            int left = LPS(i+1, j, dp, s);
            int right = LPS(i, j-1, dp, s);
            dp[i][j] = Math.max(left, right); 
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i > j) dp[i][j] = 0;
                if(i == j) dp[i][j] = 1;
            }
        }
        return LPS(0, n-1, dp, s);
    }
}