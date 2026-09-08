class Solution {
    public int f(int i, int j, int[][] dp, int m, int n){
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(i < m-1 && j < n-1){
            int down = f(i+1, j, dp, m, n);
            int right = f(i, j+1, dp, m, n);
            dp[i][j] = down + right;
        }
        else if(i == m-1) dp[i][j] = f(i, j+1, dp, m, n);
        else dp[i][j] = f(i+1, j, dp, m, n);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return f(0, 0, dp, m, n);
    }
}