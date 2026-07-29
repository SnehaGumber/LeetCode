class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1]^arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0){
                ans[i] = prefix[r];
            }
            else{
                ans[i] = prefix[l-1] ^ prefix[r];
            }
        }
        return ans;
    }
}