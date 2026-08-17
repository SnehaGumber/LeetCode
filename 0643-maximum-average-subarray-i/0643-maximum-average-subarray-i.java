class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            sum+=arr[i];
        }
        maxSum = Math.max(sum, maxSum);
        r = k - 1;
        while(r < n-1){
            sum -= arr[l];
            l++;
            r++;
            sum+=arr[r];
            maxSum = Math.max(sum, maxSum);
        }
        return (double)maxSum/k;
    }
}