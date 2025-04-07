class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if(head==null || k<=1) return head;
        Node temp = head;
        Node rh=null;
        int c =k;
        while(c>0 && head != null)
        {
           Node t = head;
           head = head.next;
           t.next = null;
           t.next = rh;
           rh = t;
           c--;
        }
        temp.next = reverseKGroup(head, k);
        return rh;
    }
}
