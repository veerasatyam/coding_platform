
// public class LC206 {
//      int val;
//     ListNode next;
//     LC206() {}
//      LC206(int val) { this.val = val; }
//      LC206(int val, ListNode next) { this.val = val; this.next = next; }
//  }
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


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}