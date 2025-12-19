class Solution{
    public boolean canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] p:prerequisites)adj.get(p[1]).add(p[0]);
        int[] visited=new int[numCourses];
        int[] pathVisited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(detectCycle(adj,i,visited,pathVisited))return false;
            }
        }
        return true;
    }
    private boolean detectCycle(List<List<Integer>> adj,int node,int[] visited,int[] pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(int next:adj.get(node)){
            if(visited[next]==0){
                if(detectCycle(adj,next,visited,pathVisited))return true;
            }else if(pathVisited[next]==1)return true;
        }
        pathVisited[node]=0;
        return false;
    }
}
