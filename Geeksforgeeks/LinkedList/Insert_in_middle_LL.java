class Solution {
    public Node insertInMiddle(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            return head;
        }

        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int middleIndex = (length - 1) / 2;  
        current = head;

        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        Node newNode = new Node(x);
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }
}