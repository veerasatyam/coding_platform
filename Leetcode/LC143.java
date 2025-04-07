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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode beforeMid = null;
        while (fast != null && fast.next != null) {
            beforeMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        beforeMid.next = null;
        ListNode firstHalf = head;
        ListNode secondHalf = slow;
        
        ListNode rh = null;
        ListNode current = secondHalf;
        while (current != null) {
            ListNode next = current.next;
            current.next = rh;
            rh = current;
            current = next;
        }
        secondHalf = rh;
        
        ListNode currentFirst = firstHalf;
        ListNode currentSecond = secondHalf;
        boolean turnFirst = true;
        
        while (currentFirst != null && currentSecond != null) {
            if (turnFirst) {
                ListNode nextFirst = currentFirst.next;
                currentFirst.next = currentSecond;
                currentFirst = nextFirst;
            } else {
                ListNode nextSecond = currentSecond.next;
                currentSecond.next = currentFirst;
                currentSecond = nextSecond;
            }
            turnFirst = !turnFirst;
        }
    }
}