// normal approach 
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }
        int ans = 0;
        for (int num : arr2) {
            int temp = num;
            while (temp > 0) {
                if (prefixes.contains(temp)) {
                    ans = Math.max(ans, String.valueOf(temp).length());
                    break;
                }
                temp /= 10;
            }
        }

        return ans;
    }
}

// using tries
class Node {
    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[10];
        flag = false;
    }

    boolean containsKey(char ch) {
        return links[ch - '0'] != null;
    }

    Node get(char ch) {
        return links[ch - '0'];
    }

    void put(char ch, Node node) {
        links[ch - '0'] = node;
    }
}

class Solution {

    private static Node root;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new Node();
        for (int num : arr1) {
            insert(String.valueOf(num));
        }
        int maxPrefix = 0;
        for (int num : arr2) {
            maxPrefix = Math.max(maxPrefix,searchPrefix(String.valueOf(num)));
        }

        return maxPrefix;
    }

    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) node.put(ch, new Node());
            
            node = node.get(ch);
        }
    }

    public static int searchPrefix(String word) {
        Node node = root;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch))break;
            node = node.get(ch);
            count++;
        }
        return count;
    }
}