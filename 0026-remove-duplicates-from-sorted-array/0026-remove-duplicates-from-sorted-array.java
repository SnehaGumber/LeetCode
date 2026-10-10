class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = l+1;

        int unique = 0;
        int idx = 0;

        while(r < n){
            if(nums[l] == nums[r]){
                l = r;
                r++;
            }else{
                unique++;
                nums[idx] = nums[l];
                idx++;
                l++;
                r++;
            }
        }
        nums[idx] = nums[l];
        l++;
        idx++;
        return unique+1;
    }
}