class Solution {
    public boolean solve(int i, int j, int[][] dp, String s, String p){
        // if both the string and target are exhausted
        if(i == s.length() && j==p.length()) return true;
        // string is exhausted but all the remaining characters in pattern are '*'
        if(i == s.length()){
            for(int k = j; k < p.length(); k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        // if target is exhausted but string is not
        if(j == p.length() && i < s.length()) return false;
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i][j] = solve(i+1, j+1, dp, s, p)? 1 : 0;
        else if(p.charAt(j) == '*'){
            boolean zeroMatch = solve(i, j+1, dp, s, p);
            boolean anyMatch = solve(i+1, j, dp, s, p);
            dp[i][j] = (zeroMatch || anyMatch)? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int i=0; i<s.length()+1; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, dp, s, p);
    }
}