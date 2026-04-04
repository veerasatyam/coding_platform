class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> list = new ArrayList<>();
        list.add(mat[0][0]);
        for (int i = 1; i < m; i++) {
            List<Integer> x = findDiagonal(mat, 0, i);
            if (i % 2 == 0) Collections.reverse(x);
            list.addAll(x);
        }
        for (int i = 1; i < n; i++) {
            List<Integer> x = findDiagonal(mat, i, m - 1);
            if ((i + m - 1) % 2 == 0) Collections.reverse(x);
            list.addAll(x);
        }
        int[] result = new int[n * m];
        for (int i = 0;i<list.size();i++)result[i] = list.get(i);
        return result;
    }
    private List<Integer> findDiagonal(int[][] mat, int i, int j) {
        List<Integer> result = new ArrayList<>();
        int x = i, y = j;
        while (x < mat.length && y >= 0) {
            result.add(mat[x][y]);
            x++;
            y--;
        }
        return result;
    }
}



// optimal version
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
    }
}