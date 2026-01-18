class DisjoinSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }else{              
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        DisjoinSet ds = new DisjoinSet(grid.length * grid[0].length);
        int n = grid.length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                            int node = i * n + j;
                            int adjNode = nr * n + nc;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }
        int maxSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> components = new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                            int adjNode = nr * n + nc;
                            components.add(ds.findParent(adjNode));
                        }
                    }
                    int sizeTotal = 1;
                    for(int parent : components){
                        sizeTotal += ds.size.get(parent);
                    }
                    maxSize = Math.max(maxSize, sizeTotal);
                }
            }
        }
        for(int i=0;i<n*n;i++){
            if(ds.parent.get(i)==i){
                maxSize = Math.max(maxSize, ds.size.get(i));
            }
        }
        return maxSize;
    }
}