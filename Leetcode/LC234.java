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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head ;
        int count=0;
        while (fast != null && fast.next != null)
        {
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rh = null;
        ListNode temp = slow;
        while(slow != null)
        {
            ListNode t = slow;
            slow = slow.next;
            t.next = null;
            t.next = rh;
            rh = t;
        }
        while(rh != null && head != null)
        {
            if(rh.val!=head.val) return false;
            rh = rh.next;
            head = head.next;
        }
        return true;
    }
}