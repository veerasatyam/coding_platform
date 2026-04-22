// User function Template for Java
class Node{
    Node[] links;
    boolean flag;
    Node(){
        links = new Node[26];
        flag = false;
    }
    public boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;
    }
    public Node get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }
}
class Trie {

    private static Node root;
    public Trie() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        int n = word.length();
        Node node = root;
        for(int i = 0;i<n;i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()) return true;
        return false;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return true;
    }
}