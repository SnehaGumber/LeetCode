class Solution {
    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        if(i < 0 || i==grid.length || j < 0 || j==grid[0].length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i-1, j, grid, visited);
        dfs(i+1, j, grid, visited);
        dfs(i, j-1, grid, visited);
        dfs(i, j+1, grid, visited);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    if(!visited[i][j]){
                        islands++;
                        dfs(i, j, grid, visited);
                    }
                }
            }
        }
        return islands;
    }
}