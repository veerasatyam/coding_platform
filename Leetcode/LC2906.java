class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = 12345;
        int size = n * m;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int[][] result = new int[n][m];
        prefix[0] = grid[0][0] % mod;
        for (int i = 1; i < size; i++) {
            int r = i / m, c = i % m;
            prefix[i] = (int)((1L * prefix[i - 1] * grid[r][c]) % mod);
        }

        suffix[size - 1] = grid[n - 1][m - 1] % mod;
        for (int i = size - 2; i >= 0; i--) {
            int r = i / m, c = i % m;
            suffix[i] = (int)((1L * suffix[i + 1] * grid[r][c]) % mod);
        }
        for (int i = 0; i < size; i++) {
            int r = i / m, c = i % m;
            if (i == 0) {
                result[r][c] = suffix[1];
            } else if (i == size - 1) {
                result[r][c] = prefix[size - 2];
            } else {
                result[r][c] = (int)((1L * prefix[i - 1] * suffix[i + 1]) % mod);
            }
        }

        return result;
    }
}


// using division operation
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int tot=1;
        int mod=12345;
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=1;
            }
        }
        long p=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=(int)p;
                p=(p*grid[i][j])%mod;
            }
        }
        long s=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                res[i][j]=(int)(res[i][j]*s)%mod;
                s=(s*grid[i][j])%mod;
            }
        }
        return res;
    }
}