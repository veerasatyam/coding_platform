class DisjoinSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjoinSet ds = new DisjoinSet(maxRow + maxCol + 1);
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
        for(int[] stone : stones){
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }
        int components = 0;
        for(int i : stoneNodes.keySet()){
            if(ds.findParent(i) == i) components++;
        }
        return stones.length - components;
    }
}