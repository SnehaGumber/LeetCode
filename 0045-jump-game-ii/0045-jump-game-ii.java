class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int currentEnd = 0;
        int farthest = 0;
        for(int i=0; i<nums.length; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(i == currentEnd){
                if(i==nums.length-1) return jump;
                else{
                    jump++;
                    currentEnd = farthest;
                }  
            }
        }
        return jump;
    }
}