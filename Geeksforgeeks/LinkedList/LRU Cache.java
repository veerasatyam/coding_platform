import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    LRUCache(int cap) {
        capacity = cap;
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            add(node);
            return;
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

        if (cache.size() > capacity) {
            Node del = tail.left;
            remove(del);
            cache.remove(del.key);
        }
    }

    private void remove(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void add(Node node) {
        node.right = head.right;
        node.left = head;

        head.right.left = node;
        head.right = node;
    }
}