

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max_row=0,max_ones=0;
        for(int i=0;i<mat.length;i++)
        {
            int one=0;
            for(int j=0;j<mat[0].length;j++)
            {
                int x = mat[i][j];
                if(x==1) one++;
            }
            if(max_ones<one) max_row=i;
            max_ones = Math.max(max_ones, one);
           
        }
        int[] Result = new int[2];
        Result[0]=max_row;
        Result[1]=max_ones;
        return Result;
    }
}