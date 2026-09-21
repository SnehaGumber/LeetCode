// class Solution {
//     public int solve(int current, int previous, int[][] dp, int[] arr){
//         if(current == arr.length) return 0;
//         if(dp[current][previous+1] != -1) return dp[current][previous+1];
//         if(previous==-1 || arr[current] > arr[previous]){
//             //take
//             int take = 1+solve(current+1, current, dp, arr);
//             //nottake
//             int nottake = solve(current+1, previous, dp, arr);
//             dp[current][previous+1] = Math.max(take, nottake);
//         }else{
//             dp[current][previous+1] = solve(current+1, previous, dp, arr);
//         }
//         return dp[current][previous+1];
//     }
//     public int lengthOfLIS(int[] nums) {
//         int[][] dp = new int[nums.length+1][nums.length+1];
//         for(int i=0; i<nums.length+1; i++) Arrays.fill(dp[i], -1);
//         return solve(0, -1, dp, nums);
//     }
// }


class Solution{
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) dp[n][i] = 0;
        for(int curr=n-1; curr>=0; curr--){
            for(int prev=-1; prev<curr; prev++){
                if(prev == -1 || nums[curr] > nums[prev]){
                    int take = 1+dp[curr+1][curr+1];
                    int nottake = dp[curr+1][prev+1];
                    dp[curr][prev+1] = Math.max(take, nottake);
                }else{
                    dp[curr][prev+1] = dp[curr+1][prev+1];
                }
            }
        }
        return dp[0][0];
    }
}