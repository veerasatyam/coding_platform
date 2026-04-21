import java.util.ArrayList;
import java.util.List;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int ultimateParent(int node){
        if(parent.get(node) == node) return node;
        int ulp = ultimateParent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }

    public void unionBySize(int u,int v){
        int ulp_u = ultimateParent(u);
        int ulp_v = ultimateParent(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);    
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            if (ds.ultimateParent(u) == ds.ultimateParent(v))return e;
            ds.unionBySize(u, v);
        }
        return new int[]{};
    }
}