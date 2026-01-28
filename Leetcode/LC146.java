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




// same but a little different implementation
class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer,Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            node.value = value;
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            insertAfterHead(newNode);
            map.put(key,newNode);
        }
    }

    public void insertAfterHead(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */