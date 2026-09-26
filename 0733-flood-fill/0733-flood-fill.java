class Solution {
    public void dfs(int i, int j, int[][] image, boolean[][] visited, int original, int color){
        if(i<0 || j<0 || i==image.length || j==image[0].length || visited[i][j] || image[i][j] != original) return;
        visited[i][j] = true;
        image[i][j] = color;
        dfs(i-1, j, image, visited, original, color);
        dfs(i+1, j, image, visited, original, color);
        dfs(i, j-1, image, visited, original, color);
        dfs(i, j+1, image, visited, original, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int original = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        dfs(sr, sc, image, visited, original, color);
        return image;
    }
}