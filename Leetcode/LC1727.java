class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 1) matrix[i][j] += matrix[i-1][j];
            }
        }
        for(int i=0;i<n;i++) sort(matrix[i]);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val = Area(matrix[i]);
            max = Math.max(val,max);
        }
        return max;
    }
    private void sort(int[] arr){
        Arrays.sort(arr);
    }
    private int Area(int[] arr){
        int max = Integer.MIN_VALUE;
        int j=0;
        int n = arr.length;
        while(j < arr.length){
            int area = arr[j] * (n - j);
            max = Math.max(area,max);
            j++;
        }
        return max;
    }
}