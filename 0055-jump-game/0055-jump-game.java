class Solution {
    public boolean canJump(int[] nums) {
        int newReach = 0;
        int farthest = 0;
        for(int i=0; i<nums.length; i++){
            if(i > farthest) return false;
            newReach = i + nums[i];
            if(newReach > farthest){
                farthest = newReach;
            }
        }
        return true;
    }
}