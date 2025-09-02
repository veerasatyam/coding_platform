class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true; 
    }
    
    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;

        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            return dfsSearch(word, index + 1, node.children[idx]);
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */