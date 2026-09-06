class Solution {
    public int climb(int i, int[] dp, int n){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int oneClimb = climb(i+1, dp, n);
        int twoClimb = climb(i+2, dp, n);
        dp[i] = oneClimb + twoClimb;
        return dp[i];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++) dp[i] = -1;
        return climb(0, dp, n);
    }
}