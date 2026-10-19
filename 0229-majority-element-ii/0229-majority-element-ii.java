class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int  n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = 0;
        int countLeft = 0;
        int countRight = 0;

        for(int i=0; i<n; i++){
            int curr = nums[i];
            if(curr == left) countLeft++;
            else if(curr == right) countRight++;
            else if(countLeft == 0){
                left = curr;
                countLeft = 1;
            }
            else if(countRight == 0){
                right = curr;
                countRight = 1;
            }
            else{
                countLeft--;
                countRight--;
            }
        }

        int freqLeft = 0;
        int freqRight = 0;

        for(int x : nums){
            if(x == left) freqLeft++;
            else if(x == right) freqRight++;
        }

        if(freqLeft > n/3) ans.add(left);
        if(freqRight > n/3) ans.add(right);
        
        return ans;
    }
}