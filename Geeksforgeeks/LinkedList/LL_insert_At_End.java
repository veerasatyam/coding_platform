class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
class Solution {
    Node insertAtEnd(Node head, int x) {
        if(head == null) {
            head = new Node(x);
            return head;
        }
        
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        Node newNode = new Node(x);
        curr.next = newNode;
        return head;
    }
}
