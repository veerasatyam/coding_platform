// using dfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target == color) return image;
        dfs(image, sr, sc, color, target);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int target) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] != target) return;
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color, target);
        dfs(image, sr - 1, sc, color, target);
        dfs(image, sr, sc + 1, color, target);
        dfs(image, sr, sc - 1, color, target);
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
    public int[][] floodFill(int[][] image,int sr,int sc,int color){
        int target=image[sr][sc];
        if(target==color)return image;
        int n=image.length,m=image[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc]=color;
        while(!q.isEmpty()){
            Pair p=q.remove();
            for(int k=0;k<4;k++){
                int nr=p.r+dr[k],nc=p.c+dc[k];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&image[nr][nc]==target){
                    image[nr][nc]=color;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return image;
    }
}
