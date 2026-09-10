// class Solution {
//     public boolean isSubsetSum(int i, int sum, int[] nums){
//         int n = nums.length;
//         boolean[][] dp = new boolean[n+1][sum+1];
//         for(int j=0; j<n+1; j++){
//             dp[j][0] = true;
//         }
//         for(int k=n-1; k>=0; k--){
//             for(int target=0; target<=sum; target++){
//                 if(nums[k] <= target){
//                     dp[k][target] = dp[k+1][target-nums[k]] || dp[k+1][target];
//                 }else{
//                     dp[k][target] = dp[k+1][target];
//                 }
//             }
//         }
//         return dp[i][sum];
//     }
//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         int n = nums.length;
//         for(int i=0; i<n; i++) total += nums[i];
//         if(total % 2 != 0) return false;
//         int target = total / 2;
//         return isSubsetSum(0, target, nums);
//     }
// }




class Solution{
    public boolean isPartition(int i, int target, int[][] dp, int[] arr){
        if(target == 0) return true;
        if(i == arr.length) return false;
        if(dp[i][target] != -1) return dp[i][target]==0 ? true : false;
        if(arr[i] > target){
            boolean res = isPartition(i+1, target, dp, arr);
            if(res) dp[i][target] = 0;
            else dp[i][target] = 1;
            return res;
        }
        else{
            boolean take = isPartition(i+1, target-arr[i], dp, arr);
            boolean nottake = isPartition(i+1, target, dp, arr);
            boolean res = take || nottake;
            if(res) dp[i][target] = 0;
            else dp[i][target] = 1;
        }
        return dp[i][target] == 0 ? true : false;
    }
    public boolean canPartition(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum += arr[i];
        if(sum % 2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);
        return isPartition(0, target, dp, arr);
    }
}


















