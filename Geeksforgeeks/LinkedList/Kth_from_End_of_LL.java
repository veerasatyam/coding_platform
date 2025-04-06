class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution {
    int getKthFromLast(Node head, int k) {
        if (head == null) {
            return -1;
        }
        
        Node first = head;
        Node second = head;
        
        for (int i = 0; i < k; i++) {
            if (first == null) {
                return -1;
            }
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        return second.data;
    }
}
