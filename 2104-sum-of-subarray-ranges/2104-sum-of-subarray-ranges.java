class Solution {
    // Sum of Subarray Minimums
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
    public long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long mintotal = 0;
        for(int i=0; i<arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            mintotal += (long)right*left*arr[i];
        }
        return mintotal;
    }
    // Sum of Subarray Maximums
    public int[] findNGE(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st1 = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st1.isEmpty() && arr[st1.peek()] <= arr[i]) st1.pop();
            if(st1.isEmpty()) nge[i] = n;
            else nge[i] = st1.peek();
            st1.push(i);
        }
        return nge;
    }
    public int[] findPGE(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st2.isEmpty() && arr[st2.peek()] < arr[i]) st2.pop();
            if(st2.isEmpty()) pge[i] = -1;
            else pge[i] = st2.peek();
            st2.push(i);
        }
        return pge;
    }
    public long sumOfSubarrayMax(int[] arr){
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long maxtotal = 0;
        for(int i=0; i<n; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            
            maxtotal += (long)left*right*arr[i];
        }
        return maxtotal;
    }
    public long subArrayRanges(int[] arr) {
        return sumOfSubarrayMax(arr) - sumSubarrayMins(arr);
    }
}