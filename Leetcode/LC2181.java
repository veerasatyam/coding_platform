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
    public ListNode mergeNodes(ListNode head) {
        if (head == null) return null;

        ListNode dummy = head;
        ListNode prev = head;
        ListNode curr = head.next;
        int sum = 0;

        while (curr != null) {
            if (curr.val != 0) {
                sum += curr.val;
            } else {
                ListNode newNode = new ListNode(sum);
                prev.next = newNode;
                prev = newNode;
                sum = 0;
            }
            curr = curr.next;
        }
        prev.next = null;
        return dummy.next;
    }
}
