
import java.util.*;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        int V = adj.size();
        boolean[] visted = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        visted[src] = true;
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int x : adj.get(curr)){
                if(!visted[x]){
                    visted[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
}

