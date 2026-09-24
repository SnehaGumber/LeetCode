// class Solution {
//     public int solve(int i, int holding, int[][] dp, int[] arr){
//         if(i >= arr.length) return 0;
//         if(dp[i][holding] != -1) return dp[i][holding];
//         if(holding == 0){
//             // buy today
//             int buyToday = -arr[i] + solve(i+1, 1, dp, arr);
//             // buy later
//             int buyLater = solve(i+1, holding, dp, arr);
//             dp[i][holding] = Math.max(buyToday, buyLater);
//         }else{
//             // sell today (cannot buy tommorow)
//             int sellToday = arr[i] + solve(i+2, 0, dp, arr);
//             // sell later
//             int sellLater = solve(i+1, holding, dp, arr);
//             dp[i][holding] = Math.max(sellToday, sellLater);
//         }
//         return dp[i][holding];
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
//         return solve(0, 0, dp, prices);
//     }
// }


class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int i=n-1; i>=0; i--){
            for(int holding=0; holding<=1; holding++){
                if(holding==0){
                    int buyToday = -prices[i] + dp[i+1][1];
                    int buyLater = dp[i+1][holding];
                    dp[i][holding] = Math.max(buyToday, buyLater);
                }else{
                    int sellToday = prices[i] + dp[i+2][0];
                    int sellLater = dp[i+1][holding];
                    dp[i][holding] = Math.max(sellToday, sellLater);
                }
            }
        }
        return dp[0][0];
    }
}