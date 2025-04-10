
/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
      Node curr = head;
      while(curr!=null && curr.next!=null)
      {
        if(curr.data==curr.next.data)
        {
            curr.next = curr.next.next;
        }
        else{
            curr = curr.next;
        }
      }
      return head;
    }
}
