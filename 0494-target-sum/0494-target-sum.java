class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int x : nums) total += x;
        if((total + target)%2!=0) return 0;
        if(target > total) return 0;
        if(target < -total) return 0;
        int reqSum = (total+target) / 2;
        int[][] dp = new int[n+1][reqSum+1];
        for(int i=0; i<n+1; i++) dp[i][0] = 1;
        for(int i=n-1; i>=0; i--){
            for(int sum=0; sum<=reqSum; sum++){
                if(nums[i] <= sum){
                    int take = dp[i+1][sum-nums[i]];
                    int nottake = dp[i+1][sum];
                    dp[i][sum] = take + nottake;
                }else{
                    dp[i][sum] = dp[i+1][sum];
                }
            }
        }
        return dp[0][reqSum];
    }
}