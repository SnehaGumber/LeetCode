class Solution {
    // public int solve(int curr, int prev, int[][] dp, int[] arr){
    //     if(curr == arr.length) return 0;
    //     if(dp[curr][prev+1] != -1) return dp[curr][prev];
    //     if(prev == -1 || arr[curr]%arr[prev]==0){
    //         int take = 1 + solve(curr+1, curr, dp, arr);
    //         int nottake = solve(curr+1, prev, dp, arr);
    //         dp[curr][prev+1] = Math.max(take, nottake);
    //     }else{
    //         dp[curr][prev+1] = solve(curr+1, prev, dp, arr);
    //     }
    //     return dp[curr][prev+1];
    // }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int curr=n-1; curr>=0; curr--){
            for(int prev=-1; prev<curr; prev++){
                if(prev==-1 || nums[curr] % nums[prev] == 0){
                    int take = 1+dp[curr+1][curr+1];
                    int nottake = dp[curr+1][prev+1];
                    dp[curr][prev+1] = Math.max(take, nottake);
                }else{
                    dp[curr][prev+1] = dp[curr+1][prev+1];
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        int prev = -1;
        while(curr < n){
            if(prev==-1 || nums[curr]%nums[prev]==0){
                int take = 1 + dp[curr+1][curr+1];
                if(take == dp[curr][prev+1]){
                    ans.add(nums[curr]);
                    prev = curr;
                    curr = curr + 1;
                }else{
                    curr = curr+1;
                }
            }else{
                curr = curr + 1;
            }
        }
        return ans;
    }
}