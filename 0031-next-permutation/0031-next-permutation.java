class Solution {
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(nums, 0, n-1);
            return;
        }

        int successor = 0;
        for(int i=n-1; i>=0; i--){
            if(nums[i] > nums[pivot]){
                successor = i;
                break;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = nums[successor];
        nums[successor] = temp;

        reverse(nums, pivot+1, n-1);
    }
}