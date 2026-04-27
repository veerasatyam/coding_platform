import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    final Map<Integer, int[][]> map = new HashMap<>();

    {
        map.put(1, new int[][]{{0, -1}, {0, 1}});
        map.put(2, new int[][]{{-1, 0}, {1, 0}});
        map.put(3, new int[][]{{0, -1}, {1, 0}});
        map.put(4, new int[][]{{0, 1}, {1, 0}});
        map.put(5, new int[][]{{0, -1}, {-1, 0}});
        map.put(6, new int[][]{{-1, 0}, {0, 1}});
    }

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(0, 0, grid, visited);
    }

    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) return true;

        visited[i][j] = true;

        for (int[] x : map.get(grid[i][j])) {
            int ni = i + x[0];
            int nj = j + x[1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || visited[ni][nj])
                continue;
            for (int[] y : map.get(grid[ni][nj])) {
                if (ni + y[0] == i && nj + y[1] == j) {
                    if (dfs(ni, nj, grid, visited)) return true;
                }
            }
        }
        return false;
    }
}




// solving this using disjoin set union 
class Solution {
    int[][][] disjoinActions = {
        {},
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{-1, 0}, {0, 1}}
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet ds = new DisjointSet(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : disjoinActions[grid[i][j]]) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                    for (int[] back : disjoinActions[grid[ni][nj]]) {
                        if (ni + back[0] == i && nj + back[1] == j) {
                            int u = i * n + j;
                            int v = ni * n + nj;
                            ds.union(u, v);
                        }
                    }
                }
            }
        }
        return ds.findULP(0) == ds.findULP(m * n - 1);
    }
}

class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findULP(int u) {
        if (u == parent.get(u)) return u;
        int ulp = findULP(parent.get(u));
        parent.set(u, ulp);
        return ulp;
    }

    public void union(int u, int v) {
        int uP = findULP(u);
        int vP = findULP(v);
        if (uP == vP) return;
        if (size.get(uP) < size.get(vP)) {
            parent.set(uP, vP);
            size.set(vP, size.get(vP) + size.get(uP));
        } else {
            parent.set(vP, uP);
            size.set(uP, size.get(uP) + size.get(vP));
        }
    }
}