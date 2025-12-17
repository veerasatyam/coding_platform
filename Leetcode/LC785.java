// using bfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for (int i = 0;i<n;i++) {
            if (color[i]==-1) {
                if (!bfsCheck(graph,i,color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfsCheck(int[][] graph,int start,int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int x:graph[node]) {
                if (color[x]==-1) {
                    color[x]=1-color[node];
                    queue.add(x);
                } else if (color[x]==color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// using dfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for (int i = 0;i<n;i++) {
            if (color[i]==-1) {
                if (!dfsCheck(graph,i,color,0)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfsCheck(int[][] graph,int node,int[] color,int c) {
        color[node]=c;
        for (int x:graph[node]) {
            if (color[x]==-1) {
                if (!dfsCheck(graph,x,color,1-c)) {
                    return false;
                }
            } else if (color[x]==color[node]) {
                return false;
            }
        }
        return true;
    }
}
