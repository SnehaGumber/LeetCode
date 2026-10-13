class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first; i<last; i++){
                int temp = mat[first][i];
                mat[first][i] = mat[n-1-i][first];
                mat[n-1-i][first] = mat[n-1-first][n-1-i];
                mat[n-1-first][n-1-i] = mat[i][n-1-first];
                mat[i][n-1-first] = temp;
            }
        }
        
    }
}