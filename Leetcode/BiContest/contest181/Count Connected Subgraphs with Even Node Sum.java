import java.util.ArrayList;
import java.util.List;

class Solution {
    int result = 0;
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        List<Integer> current = new ArrayList<>();
        backtrack(0,nums,adj,current);
        return result;
    }
    private void backtrack(int idx,int[] nums,List<List<Integer>> adj,List<Integer> current){
        if(idx == nums.length){
            if(current.size()==0) return;
            if(isValid(current,nums,adj)) result++;
            return;
        }
        current.add(idx);
        backtrack(idx + 1, nums, adj, current);
        current.remove(current.size()-1);
        backtrack(idx + 1, nums, adj, current);
    }
    private boolean isValid(List<Integer> nodes,int[] nums,List<List<Integer>> adj){
        int sum = 0;
        for(int node : nodes) sum = sum + nums[node];
        if(sum%2!=0) return false;
        Set<Integer> set = new HashSet<>(nodes);
        boolean[] visited = new boolean[nums.length];
        int start = nodes.get(0);
        int reached = dfs(start, set, adj, visited);
        return reached == nodes.size();
    }
    private int dfs(int node, Set<Integer> set, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        int count = 1;
        for(int nei : adj.get(node)){
            if(set.contains(nei) && !visited[nei]){
                count += dfs(nei, set, adj, visited);
            }
        }
        return count;
    }
}