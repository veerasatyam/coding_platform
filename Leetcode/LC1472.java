class BrowserHistory {
   class DLNode {
        String url;
        DLNode prev, next;
        public DLNode(String url) {
            this.url = url;
        }
    }
    private int size = 0;
    private DLNode head,tail,current;
    public BrowserHistory(String homepage) {
        DLNode node = new DLNode(homepage);
        head = tail = current = node;
        size++;
    }
    
    public void visit(String url) {
        DLNode node = new DLNode(url);
        current.next = node;
        node.prev = current;
        current = node;
        tail = current;
        size++;
    }
    
    public String back(int steps) {
        while(steps>0 && current.prev != null){
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && current.next != null){
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

class BrowserHistory {
    List<String> history;
    int curr;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        curr=0;
        history.add(homepage);
    }
    
    public void visit(String url) {
        int ind = history.size()-1;
        while(curr < ind){
            history.remove(ind);
            ind--;
        }
        history.add(url);
        curr++;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(history.size()-1, curr + steps);
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */