// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int total = 0;
//         for(int x : nums) total += x;
//         if((total + target)%2!=0) return 0;
//         if(target > total) return 0;
//         if(target < -total) return 0;
//         int reqSum = (total+target) / 2;
//         int[][] dp = new int[n+1][reqSum+1];
//         for(int i=0; i<n+1; i++) dp[i][0] = 1;
//         for(int i=n-1; i>=0; i--){
//             for(int sum=0; sum<=reqSum; sum++){
//                 if(nums[i] <= sum){
//                     int take = dp[i+1][sum-nums[i]];
//                     int nottake = dp[i+1][sum];
//                     dp[i][sum] = take + nottake;
//                 }else{
//                     dp[i][sum] = dp[i+1][sum];
//                 }
//             }
//         }
//         return dp[0][reqSum];
//     }
// }



class Solution {
    public int countSubsets(int i, int reqSum, int[][] dp, int[] arr){
        if(i == arr.length){
            return reqSum==0? 1:0;
        }
        if(dp[i][reqSum] != -1) return dp[i][reqSum];
        if(arr[i] <= reqSum){
            int take = countSubsets(i+1, reqSum-arr[i], dp, arr);
            int nottake = countSubsets(i+1, reqSum, dp, arr);
            dp[i][reqSum] = take + nottake;
        }else{
            dp[i][reqSum] = countSubsets(i+1, reqSum, dp, arr);
        }
        return dp[i][reqSum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int x : nums) total += x;
        if((total+target)%2 != 0) return 0;
        if(target > total) return 0;
        if(target < -total) return 0;
        int reqSum = (total+target)/2;
        int[][] dp = new int[n][reqSum+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return countSubsets(0, reqSum, dp, nums);
    }
}