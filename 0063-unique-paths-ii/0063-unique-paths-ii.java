// class Solution {
//     public int f(int i, int j, int[][] dp, int m, int n, int[][] arr){
//         if(arr[i][j] == 1) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(i==m-1 && j==n-1) return 1;
//         else if(i == m-1 && arr[i][j+1] != 1){
//             // move right
//             dp[i][j] = f(i, j+1, dp, m, n , arr);
//         }
//         else if(j == n-1 && i!=m-1 && arr[i+1][j]!=1){
//             // move down
//             dp[i][j] = f(i+1, j, dp, m, n, arr);
//         }
//         else{
//             if(i < m-1 && j < n-1 && arr[i+1][j] != 1 && arr[i][j+1] != 1){
//                 int down = f(i+1, j, dp, m, n, arr);
//                 int right = f(i, j+1, dp, m, n, arr);
//                 dp[i][j]= down+right;
//             }
//             else if(i<m-1 && arr[i+1][j] != 1){
//                 dp[i][j] = f(i+1, j, dp, m, n, arr);
//             }  
//             else if(j<n-1 && arr[i][j+1] != 1){
//                 dp[i][j] = f(i, j+1, dp, m, n, arr);
//             }
//             else dp[i][j] = 0;
//         }
//         return dp[i][j];
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m][n];
//         for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
//         return f(0, 0, dp, m, n, obstacleGrid);
//     }
// }

class Solution{
    public int uniquePathsWithObstacles(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(arr[i][j] == 1) dp[i][j] = 0;
                else if(i==m-1 && j==n-1 && arr[i][j]!=1) dp[i][j] = 1;
                else{
                    if(i<m-1 && j<n-1 && arr[i+1][j]!=1 && arr[i][j+1]!=1){
                        dp[i][j] = dp[i+1][j] + dp[i][j+1];
                    }
                    else if(i<m-1 && arr[i+1][j]!=1){
                        dp[i][j] = dp[i+1][j];
                    }
                    else if(j<n-1 && arr[i][j+1]!=1){
                        dp[i][j] = dp[i][j+1];
                    }
                    else{
                        dp[i][j] = 0;
                    } 
                }  
            }
        }
        return dp[0][0];
    }
}