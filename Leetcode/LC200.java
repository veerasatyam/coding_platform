class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    find(i, j, grid);
                }
            }
        }
        return count;
    }
    private static void find(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        find(i - 1, j, grid);
        find(i + 1, j, grid);
        find(i, j - 1, grid);
        find(i, j + 1, grid);
    }
}


// using bfs
import java.util.*;
class Solution{
    static class Pair{
        int r,c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int numIslands(char[][] grid){
        int n=grid.length,m=grid[0].length,count=0;
        int[][] vis=new int[n][m];
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    count++;
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                    while(!q.isEmpty()){
                        Pair p=q.remove();
                        for(int k=0;k<4;k++){
                            int nr=p.r+dr[k],nc=p.c+dc[k];
                            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]=='1'&&vis[nr][nc]==0){
                                vis[nr][nc]=1;
                                q.add(new Pair(nr,nc));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
