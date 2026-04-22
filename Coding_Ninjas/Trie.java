// implement_tries_II
class Node {
    Node[] links;
    int cw;
    int cp;

    Node() {
        links = new Node[26];
        cw = 0;
        cp = 0;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void increaseCw() {
        cw++;
    }

    void increaseCp() {
        cp++;
    }

    int getCw() {
        return cw;
    }

    int getCp() {
        return cp;
    }

    void decreaseCw() {
        cw--;
    }

    void decreaseCp() {
        cp--;
    }
}

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increaseCp();
        }
        node.increaseCw();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getCw();
    }
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getCp();
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return;
            }
            node = node.get(ch);
            node.decreaseCp();
        }
        node.decreaseCw();
    }
}