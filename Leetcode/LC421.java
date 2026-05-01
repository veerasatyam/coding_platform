class Node{
    Node links[];
    Node(){
        links = new Node[2];
    }
    boolean containsKey(int x){
        return (links[x] != null);
    }
    void put(int x,Node node){
        links[x] = node;
    }
    Node get(int x){
        return links[x];
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int x){
        Node node = root;
        for(int i = 31; i>=0; i--){
            int bit = (x >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }
    public int maxXor(int x){
        Node node = root;
        int result = 0;
        for(int i = 31;i >= 0; i--){
            int bit = (x >> i) & 1;
            if(node.containsKey(1 - bit)){
                result = result | 1 << i;
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return result;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int a : nums) t.insert(a);
        int max= 0;
        for(int a : nums) max = Math.max(max,t.maxXor(a));
        return max;
    }
}