class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int j=0; j<m; j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                int min = Integer.MAX_VALUE;
                // bottom
                min = Math.min(min, dp[i+1][j]);
                // right diagnol
                if(j+1 < triangle.get(i+1).size()){
                    min = Math.min(min, dp[i+1][j+1]);
                }
                dp[i][j] = triangle.get(i).get(j) + min;
            }
        }
        return dp[0][0];
    }
}