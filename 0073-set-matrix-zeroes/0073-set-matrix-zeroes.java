class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(zeroRows[i] && zeroCols[j]){
                    int row = i;
                    int col = j;
                    for(int idx=0; idx<rows; idx++) matrix[idx][col] = 0;
                    for(int idx=0; idx<cols; idx++) matrix[row][idx] = 0;
                }
            }
        }
    }
}