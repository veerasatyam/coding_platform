class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] i : invocations){
            adj.get(i[0]).add(i[1]);
        }
        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        suspicious[k] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neig : adj.get(curr)){
                if(!suspicious[neig]){
                    suspicious[neig] = true;
                    q.add(neig);
                }
            }
        }
        boolean canRemove = true;
        for(int[] i : invocations){
            if(!suspicious[i[0]] && suspicious[i[1]]){
                canRemove = false;
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!canRemove || !suspicious[i]) result.add(i);
        }
        return result;
    }
}