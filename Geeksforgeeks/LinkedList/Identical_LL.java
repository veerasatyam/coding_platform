class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public boolean areIdentical(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        while(curr1 != null && curr2 != null) {
            if(curr1.data != curr2.data) return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1 == null && curr2 == null;
    }
}
