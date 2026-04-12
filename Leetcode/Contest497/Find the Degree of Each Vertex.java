class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = count(matrix[i]);
        }
        return ans;
    }
    private int count(int[] a){
        int x=0;
        for(int i : a) if(i==1) x++;
        return x;
    }
}