class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i=0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            revAdj.get(e[1]).add(e[0]);
        }
        List<Set<Integer>> memo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            memo.add(new HashSet<>());
        }
        int[] visited = new int[n];
        for (int i=0;i<n;i++){
            if (visited[i]==0) {
                dfs(i,visited,revAdj,memo);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(memo.get(i));
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    private void dfs(int node,int[] visited,List<List<Integer>> revAdj,List<Set<Integer>> memo){
        visited[node] = 1;
        for (int parent : revAdj.get(node)) {
            if (visited[parent] == 0)dfs(parent, visited, revAdj, memo);
            memo.get(node).add(parent);
            memo.get(node).addAll(memo.get(parent));
        }
        visited[node] = 2;
    }
}


// without using hashset

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge:edges) {
            int from = edge[0], to = edge[1];
            adj[to].add(from);
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>();
            boolean[] visited = new boolean[n];

            // find children
            dfs(i, adj, visited);
            for (int j = 0; j < n; j++) {
                if (i != j && visited[j]) ancestors.add(j);
            }

            ancestorsList.add(ancestors);
        }
        return ancestorsList;
    }
    private void dfs(int node, List<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        for (int next:adj[node]) {
            if (!visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }
}

// using toposort 


class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());
       int[] indegre = new int[n];
       for (int[] e:edges) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        List<Set<Integer>> anc = new ArrayList<>();
        for(int i=0;i<n;i++) anc.add(new HashSet<>());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegre[i]==0) q.add(i);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                anc.get(v).add(u);
                anc.get(v).addAll(anc.get(u));
                indegre[v]--;
                if(indegre[v]==0) q.add(v);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> lis = new ArrayList<>(anc.get(i));
            Collections.sort(lis);
            result.add(lis);
        }
        return result;
    }
}