class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k = k % (grid.length * grid[0].length);
        for(int i = 0; i < k; i++){
            int last = grid[grid.length - 1][grid[0].length - 1];
            for(int j = grid.length - 1; j >= 0; j--){
                for(int l = grid[0].length - 1; l >= 0; l--){
                    if(j == 0 && l == 0){
                        grid[j][l] = last;
                    } else if(l == 0){
                        grid[j][l] = grid[j - 1][grid[0].length - 1];
                    } else {
                        grid[j][l] = grid[j][l - 1];
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++){
                temp.add(grid[i][j]);
            }
            res.add(temp);
        }   
        return res;
    }
}




// optimal solution 
class Solution {
    public void rev(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] flat = new int[size];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flat[idx++] = grid[i][j];
            }
        }
        k %= size;
        rev(flat, 0, size - 1);
        rev(flat, 0, k - 1);
        rev(flat, k, size - 1);
        List<List<Integer>> ans = new ArrayList<>();
        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(flat[idx++]);
            }
            ans.add(row);
        }
        return ans;
    }
}