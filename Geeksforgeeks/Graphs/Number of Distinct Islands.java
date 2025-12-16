import java.util.*;
class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (vis[i][j]==0 && grid[i][j]==1) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i,j,i,j,vis,grid,shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    private void dfs(int i,int j,int baseR,int baseC,int[][] vis,int[][] grid,ArrayList<String> shape) {
        vis[i][j] = 1;
        shape.add((i-baseR)+ "," +(j-baseC));
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,-1,0,1};
        for (int k=0;k<4;k++) {
            int nr = i + dRow[k];
            int nc = j + dCol[k];
            if (nr>=0 && nr<grid.length &&
                nc>=0 && nc<grid[0].length &&
                vis[nr][nc]==0 && grid[nr][nc]==1) {
                dfs(nr,nc,baseR,baseC,vis,grid,shape);
            }
        }
    }
}
