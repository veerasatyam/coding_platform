class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        boolean existZero = false;
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int negitive = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a = matrix[i][j];
                if(a<0) negitive++;
                if(a==0) existZero=true;
                sum += Math.abs(a);
                min = Math.min(min,Math.abs(a));
            }
        }
        if(negitive%2==0 || existZero) return sum;
        return sum - (long)2*min;
    }
}