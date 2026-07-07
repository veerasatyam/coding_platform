import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pairs{
        TreeNode node;
        int v;
        int level;
        pairs(TreeNode node,int v,int level){
            this.node = node;
            this.v = v;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> nodes = new TreeMap<>();
        Queue<pairs> queue = new LinkedList<>();
        queue.add(new pairs(root,0,0));
        while(!queue.isEmpty()){
            pairs p = queue.poll();
            TreeNode temp = p.node;
            int x = p.v;
            int y = p.level;
            nodes.putIfAbsent(x,new TreeMap<>());
            nodes.get(x).putIfAbsent(y,new PriorityQueue<>());
            nodes.get(x).get(y).offer(temp.val);
            if(temp.left != null) queue.offer(new pairs(temp.left,x-1,y+1));
            if(temp.right != null)queue.offer(new pairs(temp.right,x+1,y+1));
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : nodes.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty())col.add(pq.poll());
            }
            ans.add(col);
        }
        return ans;
    }
}