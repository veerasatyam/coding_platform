/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null)return head;
        Node nextNode = compute(head.next);
        if (nextNode.data > head.data) return nextNode;
        head.next = nextNode;
        return head;
    }
}

// optimal approach

/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        Node newhead = reverseList(head);
        Node curr = newhead;
        Node maxnode = newhead;
        
        while (curr != null && curr.next != null) {
            if (curr.next.data < maxnode.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                maxnode = curr;
            }
        }
        
        return reverseList(newhead);
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}