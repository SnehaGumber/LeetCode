class Solution {
    public int findSubarraysLessEqualSum(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubarraysLessEqualSum(nums, goal) - findSubarraysLessEqualSum(nums, goal-1);
    }
}