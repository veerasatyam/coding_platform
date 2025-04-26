/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    Node addNode(Node head, int p, int x) {
        Node curr = head;
        while (p > 0 && curr != null) {
            curr = curr.next;
            p--;
        }

        Node temp = new Node(x);
        temp.next = curr.next;
        temp.prev = curr;
        curr.next = temp;

        if (temp.next != null) {
            temp.next.prev = temp;
        }

        return head;
    }
}
