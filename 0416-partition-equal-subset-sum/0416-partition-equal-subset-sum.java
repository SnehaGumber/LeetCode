class Solution {
    public boolean isSubsetSum(int i, int sum, int[] nums){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int j=0; j<n+1; j++){
            dp[j][0] = true;
        }
        for(int k=n-1; k>=0; k--){
            for(int target=0; target<=sum; target++){
                if(nums[k] <= target){
                    dp[k][target] = dp[k+1][target-nums[k]] || dp[k+1][target];
                }else{
                    dp[k][target] = dp[k+1][target];
                }
            }
        }
        return dp[i][sum];
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) total += nums[i];
        if(total % 2 != 0) return false;
        int target = total / 2;
        return isSubsetSum(0, target, nums);
    }
}