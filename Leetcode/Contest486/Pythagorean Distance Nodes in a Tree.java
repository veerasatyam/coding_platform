class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>()); 
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int dx = x==i ? 0 : dfs(i,x,adj,new boolean[n], 0);
            int dy = y==i ? 0 : dfs(i,y,adj,new boolean[n], 0); 
            int dz = z==i ? 0 : dfs(i,z,adj,new boolean[n], 0);
            if((dx*dx + dy*dy == dz*dz) || (dx*dx + dz*dz == dy*dy) || (dy*dy + dz*dz == dx*dx)) count++;
        }
        return count;
    }
    private int dfs(int node,int target,List<List<Integer>> adj,boolean[] visited,int dist){
        if(node == target) return dist;
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                int d = dfs(neighbor, target, adj, visited, dist + 1);
                if(d != -1) return d;
            }
        }
        return -1;
    }
}




// optimised version using BFS
class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] dx = bfs(x,adj,n);
        int[] dy = bfs(y,adj,n);
        int[] dz = bfs(z,adj,n);
        int count = 0;
        for(int i=0;i<n;i++){
            long a = dx[i];
            long b = dy[i];
            long c = dz[i];
            if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a)count++;
        }
        return count;
    }

    private int[] bfs(int src, List<List<Integer>> adj, int n){
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                if(dist[nei] == -1){
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }
        return dist;
    }
}
