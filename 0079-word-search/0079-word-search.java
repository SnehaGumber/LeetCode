// class Solution {
//     public boolean solve(char[][] board, String word, boolean[][] visited, int i, int j, int idx){
//         if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
//         if(visited[i][j]) return false;
//         if(board[i][j]!=word.charAt(idx)) return false;
//         if(idx==word.length()-1) return true;
//         visited[i][j] = true;
//         boolean Up = solve(board, word, visited, i-1, j, idx+1);
//         if(Up){
//             visited[i][j] = false;
//             return true;
//         }
//         boolean Down = solve(board, word, visited, i+1, j, idx+1);
//         if(Down){
//             visited[i][j] = false;
//             return true;
//         }
//         boolean Left = solve(board, word, visited, i, j-1, idx+1);
//         if(Left){
//             visited[i][j] = false;
//             return true;
//         }
//         boolean Right = solve(board, word, visited, i, j+1, idx+1);
//         if(Right){
//             visited[i][j] = false;
//             return true;
//         }
//         visited[i][j] = false;
//         return false;
//     }
//     public boolean exist(char[][] board, String word) {
//         boolean[][] visited = new boolean[board.length][board[0].length];
//         boolean ans = false;
//         for(int i=0; i<board.length; i++){
//             for(int j=0; j<board[0].length; j++){
//                 ans = solve(board, word, visited, i, j, 0);
//                 if(ans) return true;
//             }
//         }
//         return ans;
//     }
// }

// OPTIMAL SPACE COMPLEXITY APPROACH - INSTEAD OF USING VISITED[][] ARRAY TO CHECK WHETHER AN ELEMENT HAS BEEN CHECKED OR NOT JUST UPDATE THE BOARD ITSELF REPLACING VISITED CHARACTER WITH '#'

class Solution {
    public boolean solve(char[][] board, String word, int i, int j, int idx){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        
        if(board[i][j]!=word.charAt(idx)) return false;
        if(idx==word.length()-1) return true;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean Up = solve(board, word, i-1, j, idx+1);
        if(Up){
            board[i][j] = temp;
            return true;
        }
        boolean Down = solve(board, word, i+1, j, idx+1);
        if(Down){
            board[i][j] = temp;
            return true;
        }
        boolean Left = solve(board, word, i, j-1, idx+1);
        if(Left){
            board[i][j] = temp;
            return true;
        }
        boolean Right = solve(board, word, i, j+1, idx+1);
        if(Right){
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        
        boolean ans = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ans = solve(board, word, i, j, 0);
                if(ans) return true;
            }
        }
        return ans;
    }
}