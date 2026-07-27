class Node{
    Node[] links;
    boolean flag = false;

    Node(){
        links = new Node[26];
    }

    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }

    Node get(char x){
        return links[x - 'a'];
    }

    void put(char x,Node node){
        links[x - 'a'] = node;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String word) {
        Node node = root;
        for(int i = 0;i < word.length();i++){
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */