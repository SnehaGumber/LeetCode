// class Solution {
//     int solve(int i, int holding, int[][] dp, int[] arr, int fee){
//         if(i == arr.length) return 0;
//         if(dp[i][holding] != -1) return dp[i][holding];
//         if(holding == 0){
//             int buyToday = -arr[i] + solve(i+1, 1, dp, arr, fee);
//             int buyLater = solve(i+1, holding, dp, arr, fee);
//             dp[i][holding] = Math.max(buyToday, buyLater);
//         }else{
//             int sellToday = arr[i] + solve(i+1, 0, dp, arr, fee) - fee;
//             int sellLater = solve(i+1, holding, dp, arr, fee);
//             dp[i][holding] = Math.max(sellToday, sellLater);
//         }
//         return dp[i][holding];
//     }
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
//         return solve(0, 0, dp, prices, fee);
//     }
// }


class Solution{
    public int maxProfit(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1; i>=0; i--){
            for(int holding=0; holding<=1; holding++){
                if(holding==0){
                    int buyToday = -prices[i] + dp[i+1][holding+1];
                    int buyLater = dp[i+1][holding];
                    dp[i][holding] = Math.max(buyToday, buyLater);
                }else{
                    int sellToday = prices[i] + dp[i+1][holding-1] - fee;
                    int sellLater = dp[i+1][holding];
                    dp[i][holding] = Math.max(sellToday, sellLater);
                }
            }
        }
        return dp[0][0];
    }
}