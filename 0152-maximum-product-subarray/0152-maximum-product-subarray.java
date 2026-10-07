class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for(int i=1; i<n; i++){
            int newMax = Math.max(nums[i], Math.max(nums[i]*maxProduct, nums[i]*minProduct));
            int newMin = Math.min(nums[i], Math.min(nums[i]*maxProduct, nums[i]*minProduct));
            maxProduct = newMax;
            minProduct = newMin;
            answer = Math.max(answer, newMax);
        }

        return answer;
    }
}