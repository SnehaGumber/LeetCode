// class Solution {
//     public boolean solve(int i, int j, int[][] dp, String s, String p){
//         // if both the string and target are exhausted
//         if(i == s.length() && j==p.length()) return true;
//         // string is exhausted but all the remaining characters in pattern are '*'
//         if(i == s.length()){
//             for(int k = j; k < p.length(); k++){
//                 if(p.charAt(k) != '*') return false;
//             }
//             return true;
//         }
//         // if target is exhausted but string is not
//         if(j == p.length() && i < s.length()) return false;
//         if(dp[i][j] != -1){
//             return dp[i][j] == 1;
//         }
//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i][j] = solve(i+1, j+1, dp, s, p)? 1 : 0;
//         else if(p.charAt(j) == '*'){
//             boolean zeroMatch = solve(i, j+1, dp, s, p);
//             boolean anyMatch = solve(i+1, j, dp, s, p);
//             dp[i][j] = (zeroMatch || anyMatch)? 1 : 0;
//         }
//         else{
//             dp[i][j] = 0;
//         }
//         return dp[i][j] == 1;
//     }
//     public boolean isMatch(String s, String p) {
//         int[][] dp = new int[s.length()+1][p.length()+1];
//         for(int i=0; i<s.length()+1; i++) Arrays.fill(dp[i], -1);
//         return solve(0, 0, dp, s, p);
//     }
// }


class Solution{
    public boolean isMatch(String s, String p){
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[n1][n2] = 1;
        for(int i=0; i<n1; i++) dp[i][n2] = 0;
        for(int j=n2-1; j>=0; j--){
            if(p.charAt(j) != '*') dp[n1][j] = 0;
            else{
                if(dp[n1][j+1] == 1) dp[n1][j] = 1;
                else dp[n1][j] = 0;
            }
        }
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(j) == '*'){
                    boolean zero = dp[i][j+1]==1? true : false;
                    boolean any = dp[i+1][j] == 1? true:false;
                    dp[i][j] = (zero || any)? 1 : 0;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0]==1;
    }
}