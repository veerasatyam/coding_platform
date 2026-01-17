class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) return node;
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;

        if(size.get(pu) < size.get(pv)){
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    private boolean isValid(int r, int c, int rows, int cols){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        int[][] vis = new int[rows][cols];
        int count = 0;

        List<Integer> ans = new ArrayList<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int[] op : operators){
            int r = op[0];
            int c = op[1];

            if(vis[r][c] == 1){
                ans.add(count);
                continue;
            }

            vis[r][c] = 1;
            count++;

            int node = r * cols + c;

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(isValid(nr, nc, rows, cols) && vis[nr][nc] == 1){
                    int adjNode = nr * cols + nc;
                    if(ds.findParent(node) != ds.findParent(adjNode)){
                        ds.unionBySize(node, adjNode);
                        count--;
                    }
                }
            }

            ans.add(count);
        }
        return ans;
    }
}
