class Solution {
    public void solveSudoku(char[][] board) {
        solveboard(board, 0, 0);
    }

    boolean solveboard(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solveboard(board, row + 1, 0);

        if (board[row][col] != '.') {
            return solveboard(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            char num = (char) (i + '0');
            if (cankeep(num, board, row, col)) {
                board[row][col] = num;
                if (solveboard(board, row, col + 1)) return true;
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
    }

    boolean cankeep(char num, char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }
}
