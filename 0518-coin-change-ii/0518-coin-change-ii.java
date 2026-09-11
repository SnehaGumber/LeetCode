class Solution {
    public int count(int i, int amount, int[][] dp, int[] arr){
        if(amount == 0) return 1;
        if(i == arr.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        if(arr[i] <= amount){
            int take = count(i, amount-arr[i], dp, arr);
            int nottake = count(i+1, amount, dp, arr);
            dp[i][amount] =  take + nottake;
        }else dp[i][amount] = count(i+1, amount, dp, arr);
        return dp[i][amount];
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++) Arrays.fill(dp[i], -1);
        return count(0, amount, dp, coins);
    }
}