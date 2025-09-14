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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }
        ListNode leftPrev = temp;
        ListNode leftNode = temp.next;
        ListNode newHead = Reverse(leftNode, right - left + 1);

        leftPrev.next = newHead;

        return dummy.next;
    }

    public ListNode Reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;
        while (count-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;

        return prev;
    }
}
