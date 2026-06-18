// brute force approach 
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board, solutions, n);
        return solutions;
    }

    private void solve(int row, char[][] board, List<List<String>> solutions, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(row + 1, board, solutions, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}


// optimal approach 
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] leftRow = new int[n];
        int[] Ldiagonal = new int[2*n - 1];
        int[] Udiagonal = new int[2*n - 1];
        char[][] board = new char[n][n];
        for(char[] a : board) Arrays.fill(a,'.');
        solve(0,board,leftRow,Ldiagonal,Udiagonal);
        return result;
    }
    private void solve(int row,char[][] board,int[] leftRow,int[] Ldiagonal,int[] Udiagonal){
        if(row == board.length){
            List<String> ans = new ArrayList<>();
            for(char[] a : board){
                ans.add(new String(a));
            }
            result.add(ans);
            return;
        }
        int n = board.length;
        for(int col = 0; col < n; col++){
            if(leftRow[col] == 0 && Ldiagonal[n - 1 + (col - row)] == 0 && Udiagonal[row + col] == 0){
                board[row][col] = 'Q';
                leftRow[col] = 1;
                Ldiagonal[n - 1 + (col - row)] = 1;
                Udiagonal[row + col] = 1;
                solve(row + 1,board,leftRow,Ldiagonal,Udiagonal);
                board[row][col] = '.';
                leftRow[col] = 0;
                Ldiagonal[n - 1 + (col - row)] = 0;
                Udiagonal[row + col] = 0;
            }
        }
    }
}