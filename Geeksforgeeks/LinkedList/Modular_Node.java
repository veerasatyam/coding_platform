class Node {
    int data;
     Node next;
     Node(int key)
     {
         data = key;
         next = null;
     }
}

class Solution {
    public int modularNode(Node head, int k) {
        int currentIndex = 1;
        int modularNode = -1;
        
        Node current = head;
        
        while (current != null) {
            if (currentIndex % k == 0) {
                modularNode = current.data;
            }
            current = current.next;
            currentIndex++;
        }
        
        return modularNode;
    }
}