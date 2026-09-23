class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for(int current=n-1; current>=0; current--){
            for(int transaction=k-1; transaction>=0; transaction--){
                for(int holding=0; holding<=1; holding++){
                    if(holding==0){
                        // buy today
                        int buyToday = -prices[current] + dp[current+1][transaction][holding+1];
                        // buy later
                        int buyLater = dp[current+1][transaction][holding];
                        dp[current][transaction][holding] = Math.max(buyToday, buyLater);
                    }else{
                        // sell today
                        int sellToday = prices[current] + dp[current+1][transaction+1][holding-1];
                        // sell later
                        int sellLater = dp[current+1][transaction][holding];
                        dp[current][transaction][holding] = Math.max(sellToday, sellLater);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}