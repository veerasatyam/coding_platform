class Node{
    Node[] link;
    boolean flag;
    Node(){
        link = new Node[26];
        flag = false;
    }
    public boolean containsKey(char ch){
        return (link[ch - 'a'] != null);
    }
    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;
    }
    public void put(char ch,Node node){
        link[ch-'a'] = node;
    }
    public Node get(char ch){
        return link[ch - 'a'];
    }
}
class Trie{
    public static Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkIfPrefixExist(String word){
        Node node = root;
        boolean check = true;
        for(int i = 0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                check = check && node.isEnd();
            }else return false;
        }
        return check;
    }
}
class Solution {
    public String longestValidWord(String[] words) {
       Trie T = new Trie();
       for(String w : words) T.insert(w);
        String longest = "";
        for(String w : words){
            if(T.checkIfPrefixExist(w)){
               if (w.length() > longest.length() || (w.length() == longest.length() && w.compareTo(longest) < 0)){
                    longest = w;
                }
            }
        }
        return longest;
    }
}