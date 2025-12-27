class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i=1;i<=n;i++)if(adj.get(i).size()==edges.length) return i;
        return -1;
    }
}




class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        if (edges[1][0] == a || edges[1][1] == a) return a;
        return b;
    }
}
