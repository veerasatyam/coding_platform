class Solution {
    public void solveSudoku(char[][] board) {
        solver(0, 0, board);
    }
    private boolean solver(int row, int col, char[][] board) {
        if (row == 9) return true;
        if (col == 9) return solver(row + 1, 0, board);
        if (board[row][col] != '.') {
            return solver(row, col + 1, board);
        }
        for (char num = '1'; num <= '9';num++){
            if (canKeep(row, col, board, num)) {
                board[row][col] = num;
                if (solver(row, col + 1, board)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean canKeep(int row, int col, char[][] board, char x) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == x) return false;
            if (board[i][col] == x) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == x) return false;
            }
        }
        return true;
    }
}