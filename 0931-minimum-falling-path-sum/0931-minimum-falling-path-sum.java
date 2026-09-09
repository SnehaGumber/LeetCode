// class Solution {
//     public int minCount(int i, int j, int[][] dp, int m, int n, int[][] arr){
//         if(i == m-1) return arr[i][j];
//         if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
//         int min = Integer.MAX_VALUE;
//         // left diagnol
//         if(j-1 >= 0){
//             min = Math.min(min, minCount(i+1, j-1, dp, m, n, arr));
//         }
//         // bottom
//         if(i+1 < m){
//             min = Math.min(min,minCount(i+1, j, dp, m, n, arr));
//         }
//         // right diagnol
//         if(j+1 < n){
//             min = Math.min(min,minCount(i+1, j+1, dp, m, n, arr));
//         }
//         dp[i][j] = arr[i][j] + min;
//         return dp[i][j];
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         for(int i=0; i<m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
//         int minPath = Integer.MAX_VALUE;
//         for(int idx=0; idx<n; idx++){
//             int miniPath = minCount(0, idx, dp, m, n, matrix);
//             minPath = Math.min(minPath, miniPath);
//         }
//         return minPath;
        
//     }
// }

class Solution{
    public int minFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j=0; j<n; j++){
            dp[m-1][j] = matrix[m-1][j];
        }
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int min = Integer.MAX_VALUE;
                // left diagnol
                if(j-1 >= 0)
                min = Math.min(min, dp[i+1][j-1]);
                // right diagnol
                if(j+1 < n)
                min = Math.min(min, dp[i+1][j+1]);
                // bottom
                min = Math.min(min, dp[i+1][j]);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}