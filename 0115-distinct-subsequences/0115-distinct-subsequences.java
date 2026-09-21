// class Solution {
//     public int solve(int i, int j, int[][] dp, String s, String t){
//         if(j == t.length()) return 1;
//         if(i == s.length()) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(s.charAt(i) == t.charAt(j)){
//             int pick = solve(i+1, j+1, dp, s, t);
//             int skip = solve(i+1, j, dp, s, t);
//             dp[i][j] = pick + skip;
//         }else{
//             dp[i][j] = solve(i+1, j, dp, s, t);
//         }
//         return dp[i][j];
//     }
//     public int numDistinct(String s, String t) {
//         int[][] dp = new int[s.length()+1][t.length()+1];
//         for(int i=0; i<=s.length(); i++) Arrays.fill(dp[i], -1);
//         return solve(0, 0, dp, s, t);
//     }
// }


class Solution{
    public int numDistinct(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<=s.length(); i++){
            dp[i][t.length()] = 1;
        }
        for(int j=0; j<t.length(); j++){
            dp[s.length()][j] = 0;
        }
        for(int i=s.length()-1; i>=0; i--){
            for(int j=t.length()-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}