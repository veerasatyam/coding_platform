// brute force
class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    boolean hasServerInRow = false;
                    boolean hasServerInCol = false;
                    for(int k = 0; k < m; k++){
                        if(k != j && grid[i][k] == 1){
                            hasServerInRow = true;
                            break;
                        }
                    }
                    for(int k = 0; k < n; k++){
                        if(k != i && grid[k][j] == 1){
                            hasServerInCol = true;
                            break;
                        }
                    }
                    if(hasServerInRow || hasServerInCol){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] rows= new int[m];
        int[] cols= new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&(rows[i]>1||cols[j]>1)){
                    count++;
                }
            }
        }
        return count;
    }
}