class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int evenIdx = 0;
        int oddIdx = 1;

        for(int x : nums){
            if(x > 0){
                ans[evenIdx] = x;
                evenIdx += 2;
            }else{
                ans[oddIdx] = x;
                oddIdx += 2;
            }
        }

        return ans;
    }
}