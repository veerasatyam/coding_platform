class LFUCache {
    class Node{
        int value,key,count;
        Node prev,next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }
    private Map<Integer,Node> cacheMap;
    private Map<Integer,DoublyLinkedList> freqMap;
    private int capacity;
    private int minFreq;

    class DoublyLinkedList{
        Node head,tail;
        int size;
        DoublyLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        public void addNode(Node node){
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }
        public void removeNode(Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)) return -1;
        Node node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cacheMap.size() == capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node lastNode = minFreqList.tail.prev;
                minFreqList.removeNode(lastNode);
                cacheMap.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addNode(newNode);
            freqMap.put(1, list);
            minFreq = 1;
        }
    }
    void updateFrequency(Node node){
        int currFreq = node.count;
        DoublyLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(node);
        if(currFreq == minFreq && currList.size == 0){
            minFreq++;
        }
        node.count++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.count, new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(node.count, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */