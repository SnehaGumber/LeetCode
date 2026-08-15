class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lMax =0, rMax = 0, total = 0;
        int l = 0, r = n-1;
        while(l < r){
            if(arr[l] <= arr[r]){
                if(lMax > arr[l]){
                    total += lMax - arr[l];
                }else{
                    lMax = arr[l];
                }
                l = l+1;
            }else{
                if(rMax > arr[r]){
                    total += rMax - arr[r];
                }else{
                    rMax = arr[r];
                }
                r = r-1;
            }
        }
        return total;
    }
}