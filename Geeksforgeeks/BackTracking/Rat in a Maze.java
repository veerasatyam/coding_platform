import java.util.*;

class Solution {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        if (maze[0][0] == 0) return result;
        boolean[][] visited = new boolean[n][n];
        helper(0, 0, maze, "", visited);
        Collections.sort(result);
        return result;
    }

    public void helper(int i, int j, int[][] maze, String curr, boolean[][] visited) {

        int n = maze.length;
        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            result.add(curr);
            return;
        }
        visited[i][j] = true;
        helper(i + 1, j, maze, curr + "D", visited);
        helper(i, j - 1, maze, curr + "L", visited);
        helper(i, j + 1, maze, curr + "R", visited);
        helper(i - 1, j, maze, curr + "U", visited);
        visited[i][j] = false;
    }
}