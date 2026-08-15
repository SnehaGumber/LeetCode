class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int z = 0;
        int n = arr.length;
        int[] ans = new int[n-k+1];
        while(r < n){
            while(!dq.isEmpty() && dq.peekFirst()<l) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[r]) dq.pollLast();
            dq.offerLast(r);
            if(r-l+1 == k){
                int max = arr[dq.peekFirst()];
                ans[z++] = max;
                l++;
            }
            r++;

        }
        return ans;
    }
}