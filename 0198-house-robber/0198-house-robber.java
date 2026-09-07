class Solution {
    public int helper(int i, int[] dp, int[] nums){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        // take
        int take = nums[i] + helper(i+2, dp, nums);
        // not take
        int nottake = helper(i+1, dp, nums);
        dp[i] = Math.max(take, nottake);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++) dp[i] = -1;
        return helper(0, dp, nums);
    }
}