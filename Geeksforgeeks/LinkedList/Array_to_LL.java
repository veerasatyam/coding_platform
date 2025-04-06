class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }
}

class Solution {
    
    static Node constructLL(int arr[]) {
        if (arr.length == 0) {
            return null;
        }
        
        Node head = new Node(arr[0]);
        Node current = head;
        
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = newNode;
        }
        
        return head;
    }
}
