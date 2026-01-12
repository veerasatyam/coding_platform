import java.util.*;
// union by rank and path compression
//key methods: findParent(), unionByRank()
// key remainders: in findParent do path compression by setting parent of node to ultimate parent and in unionByRank attach smaller rank tree under larger rank tree
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);    
        }else{
            parent.set(ulp_v,ulp_u);    
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}
class Main{
    public static void main(String args[]){
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Same Parent");
        }else{
            System.out.println("Different Parent");
        }
         ds.unionByRank(3,7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Same Parent");
        }else{
            System.out.println("Different Parent");
        }
    }
}


// union by size and path compression
//key methods: findParent(), unionBySize()
// key remainders: in findParent do path compression by setting parent of node to ultimate parent and in unionBySize attach smaller size tree under larger size tree
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
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
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);    
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Main{
    public static void main(String args[]){
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Same Parent");
        }else{
            System.out.println("Different Parent");
        }
         ds.unionBySize(3,7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("Same Parent");
        }else{
            System.out.println("Different Parent");
        }
    }
}