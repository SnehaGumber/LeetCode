class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = col-1;
        int top = 0;
        int bottom = row-1;

        while(left <= right && top <= bottom){

            for(int i=left; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(bottom >= top){
                for(int j=right; j>=left; j--){
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(right >= left){
                for(int j=bottom; j>=top; j--){
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }

        return ans;
    }
}