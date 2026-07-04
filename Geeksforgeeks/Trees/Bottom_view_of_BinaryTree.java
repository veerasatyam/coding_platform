class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node node = p.node;
            int hd = p.hd;
            map.put(hd, node.data);
            if (node.left != null) queue.offer(new Pair(node.left, hd - 1));
            if (node.right != null) queue.offer(new Pair(node.right, hd + 1));
        }
        for (int val : map.values())result.add(val);
        return result;
    }

    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}


// DFS Approach 
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    static class Pair{
        int data;
        int depth;
        Pair(int data,int depth){
            this.data = data;
            this.depth = depth;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        if(root == null) return new ArrayList<>();
        minHd = 0;
        maxHd = 0;
        Map<Integer,Pair> hdmap = new HashMap<>();
        dfs(root,0,0,hdmap);
        ArrayList<Integer> result = new ArrayList<>();
        for(int hd = minHd; hd <= maxHd; hd++){
            result.add(hdmap.get(hd).data);
        }
    }
    private static void dfs(Node root,int hd,int depth,Map<Integer,Pair> hdmap){
        if(root == null) return;
        minHd = Math.min(minHd,hd);
        maxHd = Math.max(maxHd,hd);
        if(!hdmap.containsKey(hd) || depth >= hdmap.get(hd).depth){
            hdmap.put(hd,new Pair(root.data,depth));
        }
        dfs(root.left,hd - 1,depth+1,hdmap);
        dfs(root.right,hd + 1, depth + 1,hdmap);
    }
}