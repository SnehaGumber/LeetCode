class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                swap(nums, idx, i);
                idx++;
            }
        }
    }
}