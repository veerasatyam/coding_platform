/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null) return null;

        if (x == 1) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }

        Node curr = head;
        for (int i = 1; i < x && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            if (curr.prev != null) curr.prev.next = curr.next;
            if (curr.next != null) curr.next.prev = curr.prev;
        }
        return head;
    }
}
