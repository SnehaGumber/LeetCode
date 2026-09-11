// class Solution {
//     public int helper(int amount, int[] dp, int[] arr){
//         if(amount == 0) return 0;
//         if(amount < 0) return -1;
//         if(dp[amount] != Integer.MAX_VALUE) return dp[amount];
//         int mini = Integer.MAX_VALUE;
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] <= amount){
//                 int res = helper(amount-arr[i], dp, arr);
//                 if(res != -1) mini = Math.min(mini, 1+res);
//             }
//         }
//         if(mini == Integer.MAX_VALUE) dp[amount] = -1;
//         else dp[amount] = mini;
//         return dp[amount];
//     }
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[] dp = new int[amount+1];
//         for(int i=0; i<amount+1; i++) dp[i] = Integer.MAX_VALUE;
//         return helper(amount, dp, coins);
//     }
// }


class Solution{
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int target=1; target<=amount; target++){
                if(coins[i] <= target){
                    if(dp[target-coins[i]]!= Integer.MAX_VALUE){
                        dp[target] = Math.min(dp[target], 1+dp[target-coins[i]]);
                    }
                }

            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}