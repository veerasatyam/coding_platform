class Solution {
    public void solve(char[][] board) {
        int n = board.length,m=board[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(board,visited,i,0);
            if(board[i][m-1]=='O') dfs(board,visited,i,m-1);
            
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O') dfs(board,visited,n-1,i);
            if(board[0][i]=='O') dfs(board,visited,0,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (board[i][j]=='O'&&visited[i][j]!=1)board[i][j]='X';
            }
        }
    }
    private void dfs(char[][] board,int[][] visited,int i,int j){
        if(i<0 || i>= visited.length || j<0 || j>= visited[0].length) return;
        if(board[i][j]=='X' || visited[i][j]==1) return;
        visited[i][j] = 1;
        dfs(board,visited,i+1,j);
        dfs(board,visited,i,j+1);
        dfs(board,visited,i-1,j);
        dfs(board,visited,i,j-1);
    }
}