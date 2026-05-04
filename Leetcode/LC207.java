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



//using toposort
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        return count == numCourses;
    }
}