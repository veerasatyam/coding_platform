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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode check = head;
        int count = 0;
        while (count < k && check != null) {
            check = check.next;
            count++;
        }
        if (count < k) return head;

        ListNode rh = null;
        ListNode temp = head;
        int c = k;
        while (c > 0 && head != null) {
            ListNode t = head;
            head = head.next;
            t.next = rh;
            rh = t;
            c--;
        }

        temp.next = reverseKGroup(head, k);
        return rh;
    }
}
