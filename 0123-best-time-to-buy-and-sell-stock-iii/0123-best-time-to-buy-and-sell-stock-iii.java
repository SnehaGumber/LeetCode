class Solution {
    public int solve(int current, int transaction, boolean holding, int[][][] dp, int[] arr){
        if(current == arr.length) return 0;
        if(transaction == 2) return 0;
        if(dp[current][transaction][holding?1:0] != -1) return dp[current][transaction][holding?1:0];
        if(!holding){
            int buyToday = -arr[current] + solve(current+1, transaction, true, dp, arr);
            int buyLater = solve(current+1, transaction, false, dp, arr);
            dp[current][transaction][holding?1:0] = Math.max(buyToday, buyLater);
        }else{
            int sellToday = arr[current] + solve(current+1, transaction+1, false, dp, arr);
            int sellLater = solve(current+1, transaction, true, dp, arr);
            dp[current][transaction][holding?1:0] = Math.max(sellToday, sellLater);
        }
        return dp[current][transaction][holding?1:0];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<3; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, false, dp, prices);
    }
}