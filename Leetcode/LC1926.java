class Solution {
    class Pair{
        int row;
        int col;
        int step;
        Pair(int row,int col,int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0],entrance[1],0));
        maze[entrance[0]][entrance[1]] = '+';
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair x = q.poll();
            int r = x.row;
            int c = x.col;
            int steps = x.step;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.'){
                    if(nr == 0 || nr == m - 1 || nc == 0 || nc == n-1){
                        return steps + 1;
                    }
                    maze[nr][nc] = '+';
                    q.add(new Pair(nr,nc,steps + 1));
                }
            }
        }
        return -1;
    }
}