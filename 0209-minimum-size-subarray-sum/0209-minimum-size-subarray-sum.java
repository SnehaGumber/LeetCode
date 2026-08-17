class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int n = arr.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < n){
            if(sum < target){
                sum+=arr[r];
                r++;
            }
            while(sum >= target){
                minLen = Math.min(minLen, r-l);
                l++;
                sum -= arr[l-1];
            }
            
        }
        return minLen==Integer.MAX_VALUE? 0 : minLen;
    }
}