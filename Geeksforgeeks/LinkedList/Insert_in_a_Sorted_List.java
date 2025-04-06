class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class Solution {
    Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);
        
        if (head == null || head.data >= key) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        Node curr = head;
        while (curr.next != null && curr.next.data < key) {
            curr = curr.next;
        }
        
        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }
}