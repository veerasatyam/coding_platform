class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    if(i>0 && board[i-1][j]=='X') continue;
                    if(j>0 && board[i][j-1]=='X') continue;
                    count++;
                }
            }
        }
        return count;
    }
}


// using dfs

class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'X') {
            return;
        }
        board[i][j] = '.';
        dfs(board, i + 1, j, rows, cols);
        dfs(board, i - 1, j, rows, cols);
        dfs(board, i, j + 1, rows, cols);
        dfs(board, i, j - 1, rows, cols);
    }
}
