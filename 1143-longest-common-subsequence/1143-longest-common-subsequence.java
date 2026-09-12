// class Solution {
//     public int LCS(int i, int j, int[][] dp, String s1, String s2){
//         int l1 = s1.length();
//         int l2 = s2.length();
//         if(i==l1 || j==l2) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + LCS(i+1, j+1, dp, s1, s2);
//         else{
//             int first = LCS(i+1, j, dp, s1, s2);
//             int second = LCS(i, j+1, dp, s1, s2);
//             dp[i][j] = Math.max(first, second);
//         }
//         return dp[i][j];
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n1 = text1.length();
//         int n2 = text2.length();
//         int[][] dp = new int[n1+1][n2+1];
//         for(int i=0; i<=n1; i++) Arrays.fill(dp[i], -1);
//         return LCS(0, 0, dp, text1, text2);
//     }
// }


class Solution{
    public int longestCommonSubsequence(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++) Arrays.fill(dp[i], -1);
        for(int i=0; i<n1+1; i++){
            dp[i][n2] = 0;
        }
        for(int i=0; i<=n2; i++){
            dp[n1][i] = 0;
        }
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    int f = dp[i+1][j];
                    int s = dp[i][j+1];
                    dp[i][j] = Math.max(f, s);
                }
            }
        }
        return dp[0][0];
    }
}