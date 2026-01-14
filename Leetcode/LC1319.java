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
        if(node==parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v) return;
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
    public int makeConnected(int n, int[][] connections) {
        DisjoinSet ds = new DisjoinSet(n);
        int extraEdges = 0;
        for(int[] e : connections){
            int u = e[0];
            int v = e[1];
            if(ds.findParent(u)==ds.findParent(v)){
                extraEdges++;
            }
            else{
                ds.unionBySize(u,v);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i) count++;
        }
        if(extraEdges >= count - 1) return count - 1;
        return -1;
    }
}