class RecentCounter {
    Deque<Integer> deq;
    public RecentCounter() {
        deq = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        int x = t;
        deq.addLast(t);
        while(!deq.isEmpty() && deq.peekFirst() < (x - 3000)) deq.removeFirst();
        return deq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */