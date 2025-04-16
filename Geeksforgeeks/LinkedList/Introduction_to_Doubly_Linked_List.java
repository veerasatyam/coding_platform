class Solution {
    static class Node {
        int data;
        Node prev, next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node constructDLL(int arr[]) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        return head;
    }
}
