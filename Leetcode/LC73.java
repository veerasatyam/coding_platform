import java.util.ArrayList;
import java.util.HashMap;

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
//         int n = matrix.length, m = matrix[0].length;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix[i][j] == 0) {
//                     if (!hm.containsKey(i)) {
//                         hm.put(i, new ArrayList<>());
//                     }
//                     hm.get(i).add(j);
//                 }
//             }
//         }
//         for (int row : hm.keySet()) {
//             for (int j = 0; j < m; j++) {
//                 matrix[row][j] = 0;
//             }
//         }
//         for (ArrayList<Integer> cols : hm.values()) {
//             for (int col : cols) {
//                 for (int i = 0; i < n; i++) {
//                     matrix[i][col] = 0;
//                 }
//             }
//         }
//     }
// }

// using O(n + m) space complexity
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// this solution is came from the above appraoch solution insted of taking an extre row array and col array we can use the first row and first column of the matrix itself to store the information about which row and column should be made zero and we can use two boolean variable to track whether the first row and first column should be made zero or not
// using O(1) space complexity
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean row0 = false, col0 = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = true;
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) row0 = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
