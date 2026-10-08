class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int currMax = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<n; i++){
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxSum = Math.max(currMax, maxSum);
        }

        int currMin = nums[0];
        int minSum = nums[0];

        for(int i=1; i<n; i++){
            currMin = Math.min(nums[i], currMin+nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        int totalSum = 0;
        for(int x : nums) totalSum += x;

        int wrappingSum = totalSum - minSum;

        if(maxSum < 0){
            return maxSum;
        }else{
            return Math.max(maxSum, wrappingSum);
        }
    }
}