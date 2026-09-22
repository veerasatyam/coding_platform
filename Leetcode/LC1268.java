class Node{
    Node[] links;
    boolean flag;
    public Node(){
        links = new Node[26];
        flag = false;
    }
    public Node get(char ch){
        return links[ch - 'a'];
    }
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    public void put(char ch,Node node){
        links[ch - 'a'] = node;
    }
    public void setEnd(){
        flag = true;
    }
}
class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public List<String> getWords(Node node,String prefix){
        List<String> words = new ArrayList<>();
        if(node.flag){
            words.add(prefix);
        }
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(node.containsKey(ch)){
                words.addAll(getWords(node.get(ch),prefix + ch));
            }
        }
        return words;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String x : products) trie.insert(x);
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            Node node = trie.root;
            boolean found = true;
            for (int j = 0; j < prefix.length(); j++) {
                char ch = prefix.charAt(j);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    found = false;
                    break;
                }
            }
            if (!found) {
                result.add(new ArrayList<>());
                for (int k = i + 1; k < searchWord.length(); k++) {
                    result.add(new ArrayList<>());
                }
                break;
            }
            List<String> words = trie.getWords(node, prefix);
            Collections.sort(words);
            List<String> top3 = new ArrayList<>();
            for (int j = 0; j < Math.min(3, words.size()); j++) {
                top3.add(words.get(j));
            }
            result.add(top3);
        }
        return result;
    }
}
