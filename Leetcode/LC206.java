
public class ListNode {
     int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode rh = null;
        while(head != null)
        {
            ListNode t = head;
            head = head.next;
            t.next=null;
            t.next = rh;
            rh = t;
        }
        return rh;
    }
}