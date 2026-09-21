class Solution {
    public int solve(int current, int previous, int[][] dp, int[] arr){
        if(current == arr.length) return 0;
        if(dp[current][previous+1] != -1) return dp[current][previous+1];
        if(previous==-1 || arr[current] > arr[previous]){
            //take
            int take = 1+solve(current+1, current, dp, arr);
            //nottake
            int nottake = solve(current+1, previous, dp, arr);
            dp[current][previous+1] = Math.max(take, nottake);
        }else{
            dp[current][previous+1] = solve(current+1, previous, dp, arr);
        }
        return dp[current][previous+1];
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0; i<nums.length+1; i++) Arrays.fill(dp[i], -1);
        return solve(0, -1, dp, nums);
    }
}