// brute force
class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        List<List<Integer>> store = new ArrayList<>();
           int n = mat.length;
         for (int i = 0; i < 2 * n - 1; i++) {
            store.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                store.get(i+j).add(mat[i][j]);
            }
        }
        int x = 2*n-2;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<=x;i++){
            result.addAll(store.get(i));
        }
        return result;
    }
}


// space optimisation and expected approach 
class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();
        for (int d = 0;d < n;d++) {
            int i = 0,j = d;
            while (i < n && j >= 0) {
                result.add(mat[i][j]);
                i++;
                j--;
            }
        }
        for (int row = 1;row<n;row++) {
            int i = row, j = n - 1;
            while (i < n && j >= 0) {
                result.add(mat[i][j]);
                i++;
                j--;
            }
        }
        return result;
    }
}