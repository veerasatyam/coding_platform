class Solution {
    private void preOrder(Node root,ArrayList<String> ans,String curr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(curr.equals("")) curr = "0";
            ans.add(curr);
            return;
        }
        preOrder(root.left,ans,curr + "0");
        preOrder(root.right,ans,curr + "1");
    }
    class Node{
        int index,freq;
        Node left,right;
        Node(int index,int freq){
            this.index = index;
            this.freq = freq;
            left = right = null;
        }
        Node(Node l,Node r){
            freq = l.freq + r.freq;
            index = Math.min(l.index, r.index); 
            left = l;
            right = r;
        }
    }
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        int n = s.length();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) ->{
            if(a.freq != b.freq){
                return a.freq - b.freq;
            }
            return a.index - b.index;
        });
        for(int i =0;i<n;i++){
            Node temp = new Node(i,f[i]);
            pq.add(temp);
        }
        if(n==1){
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }
        while(pq.size() >= 2){
            Node l = pq.poll();
            Node r = pq.poll();
            Node newNode = new Node(l,r);
            pq.add(newNode);
        }
        Node root = pq.peek();
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root,ans,"");
        return ans;
    }
}