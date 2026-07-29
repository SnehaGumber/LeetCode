class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
        }
        int rightSetBit = 0;
        for(int i=0; i<32; i++){
            if((xor&(1 << i)) != 0){
                rightSetBit = i;
                break;
            }
        }
        int[] res = new int[2];
        int grp1 = 0;
        int grp2 = 0;
        for(int i=0; i<nums.length; i++){
            if((nums[i]&(1 << rightSetBit)) != 0){
                grp1 ^= nums[i];
            }
            else{
                grp2 ^= nums[i];
            }
        }
        res[0] = grp1;
        res[1] = grp2;
        return res;
    }
}