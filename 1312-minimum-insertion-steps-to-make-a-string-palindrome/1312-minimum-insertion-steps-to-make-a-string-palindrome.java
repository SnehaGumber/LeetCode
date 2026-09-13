// class Solution {
//     public int count(int i, int j, int[][] dp, String s){
//         if(i == j) return 0;
//         if(i > j) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(s.charAt(i) == s.charAt(j)) dp[i][j] = count(i+1, j-1, dp, s);
//         else{
//             int left = 1 + count(i+1, j, dp, s);
//             int right = 1 + count(i, j-1, dp, s);
//             dp[i][j] = Math.min(left, right);
//         }
//         return dp[i][j];
//     }
//     public int minInsertions(String s) {
//         int n = s.length();
//         int[][] dp = new int[n][n];
//         for(int i=0; i<n; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         return count(0, n-1, dp, s);
//     }
// }

class Solution{
    public int minInsertions(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int L=2; L<=n; L++){
            for(int i=0; i<n-L+1; i++){
                int j = i+L-1;
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}