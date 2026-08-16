class Solution {
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[arr.length];
        Stack<Integer> nst = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!nst.isEmpty() && arr[nst.peek()] >= arr[i]) nst.pop();
            if(nst.isEmpty()) nse[i] = n;
            else nse[i] = nst.peek();
            nst.push(i);
        }
        return nse;
    }
    public int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> pst = new Stack<>();
        for(int i=0; i<n; i++){
            while(!pst.isEmpty() && arr[pst.peek()] > arr[i]) pst.pop();
            if(pst.isEmpty()) pse[i] = -1;
            else pse[i] = pst.peek();
            pst.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        long mod = 1000000007;
        for(int i=0; i<arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long contribution = ((long)right*left*arr[i]) % mod;
            total = (total + contribution) % mod;
        }
        return (int)total;
    }
}