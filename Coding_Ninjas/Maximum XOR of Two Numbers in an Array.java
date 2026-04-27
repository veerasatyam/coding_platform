class Node{
    Node links[];
    Node(){
        links = new Node[2];
    }
    public void put(int x,Node node){
        links[x] = node;
    }
    public Node get(int x){
        return links[x];
    }
    public boolean containsKey(int x){
        return (links[x] != null);
    }
}
class Trie{
    public static Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int n){
        Node node = root;
        for(int i = 31;i >= 0; i--){
            int x = (n >> i) & 1;
            if(!node.containsKey(x)){
                node.put(x,new Node());
                node = node.get(x);
            }else node = node.get(x);
        }
    }
    public int find_Num(int target){
        int result = 0;
        Node node = root;
        for(int i=31;i>=0;i--){
            int x = (target >> i) & 1;
            if(node.containsKey(1-x)){
                result = result | (1 << i);
                node = node.get(1-x);
            }else node = node.get(x);
        }
        return result;
    }
}
public class Solution {
    public static int maximumXor(int []A) {
        Trie t = new Trie();
        for(int x : A) t.insert(x);
        int max = Integer.MIN_VALUE;
        for(int x : A){
            max  = Math.max(max,t.find_Num(x));
        }
        return max;
    }
}
