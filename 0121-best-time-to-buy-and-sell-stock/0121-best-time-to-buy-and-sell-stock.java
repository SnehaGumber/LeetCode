// class Solution {
//     public int solve(int i, int boughtAt, int[][] dp, int[] arr){
//         if(i == arr.length) return 0;
//         if(dp[i][boughtAt+1] != -1) return dp[i][boughtAt+1];
//         if(boughtAt == -1){
//             int buyToday = solve(i+1, i, dp, arr);
//             int buyLater = solve(i+1, boughtAt, dp, arr);
//             dp[i][boughtAt+1] = Math.max(buyToday, buyLater);
//         }else{
//             int sellToday = arr[i] - arr[boughtAt];
//             int sellLater = solve(i+1, boughtAt, dp, arr);
//             dp[i][boughtAt+1] = Math.max(sellToday, sellLater);
//         }
//         return dp[i][boughtAt+1];
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][n+1];
//         for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
//         return solve(0, -1, dp, prices);
//     }
// }


class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[] minPrices = new int[n];
        minPrices[0] = prices[0];
        for(int i=1; i<n; i++){
            minPrices[i] = Math.min(prices[i], minPrices[i-1]);
        }
        
        int[] profit = new int[n];
        for(int i=0; i<n; i++){
            profit[i] = prices[i] - minPrices[i];
        }

        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxProfit = Math.max(maxProfit, profit[i]);
        }

        return maxProfit;
        
    }
}