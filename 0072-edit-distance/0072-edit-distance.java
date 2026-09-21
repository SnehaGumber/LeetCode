class Solution {
    public int solve(int i, int j, int[][] dp, String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(i == n1) return n2 - j;
        if(j == n2) return n1 - i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = solve(i+1, j+1, dp, s1, s2);
        else{
            int insert = 1+solve(i,  j+1, dp, s1, s2);
            int delete = 1+solve(i+1, j, dp, s1, s2);
            int replace = 1+solve(i+1, j+1, dp, s1, s2);
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length()+1; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, dp, word1, word2);
    }
}