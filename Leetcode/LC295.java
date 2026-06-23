// brute force approach

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class MedianFinder {
    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        Collections.sort(nums);
        int n = nums.size();
        if(n % 2 == 1) return nums.get(n / 2);
        return (nums.get(n/2 - 1) + nums.get(n/2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// optima Approach 
// brute force approach
class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
       maxheap = new PriorityQueue<>(Collections.reverseOrder());
       minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if(minheap.size() > maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() == minheap.size()) return(maxheap.peek() + minheap.peek()) / 2.0;
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */