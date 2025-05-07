import java.util.HashMap;

class LRUCache {
    class Node {
        int k, v;
        Node next, prev;
        Node(int key, int value) {
            k = key;
            v = value;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private HashMap<Integer, Node> hm = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        Node node = hm.get(key);
        deleteNode(node);
        insertBeforeTail(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            deleteNode(node);
            node.v = value;
            insertBeforeTail(node);
        } else {
            if (hm.size() == capacity) {
                Node lru = head.next;
                deleteNode(lru);
                hm.remove(lru.k);
            }
            Node newNode = new Node(key, value);
            insertBeforeTail(newNode);
            hm.put(key, newNode);
        }
    }

    private void insertBeforeTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }
}
