class Solution {
    public int[] findOrder(int numCourses,int[][] prerequisites){
        int[] result=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int[] inDegree=new int[numCourses];
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0) q.add(i);
        int idx=0;
        while(!q.isEmpty()){
            int node=q.remove();
            result[idx++]=node;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        return idx==numCourses?result:new int[0];
    }
}


