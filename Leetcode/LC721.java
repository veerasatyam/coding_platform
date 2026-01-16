class DisjoinSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void unionBySize(int u,int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) retunrn;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjoinSet ds = new DisjoinSet(n);
        HashMap<String,Integer> mapMailNode = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail,i);
                }
                else{
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }
        HashMap<Integer,ArrayList<String>> mapNodeMails = new HashMap<>();
        for(Map.Entry<String,Integer> entry : mapMailNode.entrySet()){
            String mail = entry.getKey();
            int node = entry.getValue();
            int ulp = ds.findUpar(node);
            mapNodeMails.putIfAbsent(ulp,new ArrayList<>());
            mapNodeMails.get(ulp).add(mail);
        }       
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<String>> entry : mapNodeMails.entrySet()){  
            int node = entry.getKey();
            ArrayList<String> mails = entry.getValue();
            Collections.sort(mails);
            String name = accounts.get(node).get(0);
            ArrayList<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);
            mergedAccount.addAll(mails);
            mergedAccounts.add(mergedAccount);
        }       
        return mergedAccounts;
    }
}