import java.util.*;
class Solution {
    class Node {
        int r, c, d;
        Node(int r,int c,int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node x = q.poll();
            int i = x.r, j = x.c, dis = x.d;
            distance[i][j] = dis;

            for (int k=0;k<4;k++){
                int nr =i + dr[k];
                int nc =j + dc[k];
                if (nr>=0 && nr<n && nc>=0 && nc<m
                        && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr,nc,dis + 1));
                }
            }
        }
        return distance;
    }
}
