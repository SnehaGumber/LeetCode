class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n = arr.length;

        int maxOnes = Integer.MIN_VALUE;

        int count = 0;

        for(int i=0; i<n; i++){
            
            if(arr[i] == 0){
                count = 0;
            }else{
                count++;
            }
            maxOnes = Math.max(maxOnes, count);
        }
        return maxOnes;
    }
}