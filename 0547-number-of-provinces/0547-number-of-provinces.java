class Solution {
    public void dfs(int u, int n, int[][] arr, boolean[] visited){
        visited[u] = true;
        for(int v=0; v<n; v++){
            if(arr[u][v] == 1){
                if(!visited[v]){
                    visited[v] = true;
                    dfs(v, n, arr, visited);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, n, isConnected, visited);
            }
        }
        return provinces;
    }
}