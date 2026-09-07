// class Solution {
//     public int helper(int i, int[] dp, int[] nums){
//         if(i >= nums.length) return 0;
//         if(dp[i] != -1) return dp[i];
//         // take
//         int take = nums[i] + helper(i+2, dp, nums);
//         // not take
//         int nottake = helper(i+1, dp, nums);
//         dp[i] = Math.max(take, nottake);
//         return dp[i];
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+1];
//         for(int i=0; i<n+1; i++) dp[i] = -1;
//         return helper(0, dp, nums);
//     }
// }

class Solution{
    public int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            int take = 0;
            if(i+2 >= n) take = 0;
            else take = dp[i+2];
            dp[i] = Math.max(nums[i]+take, dp[i+1]);

        }
        return dp[0];
    }
}