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

        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if (count < k) return head;

        ListNode prev = null;
        curr = head;
        int c = k;
        while (c-- > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;        
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        while (curr != null) {
            ListNode groupStart = curr;
            ListNode groupEnd = getGroupEnd(curr, k);
            if (groupEnd == null) break;
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;
            prevGroupEnd.next = reverse(groupStart);
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }
        return dummy.next;
    }
    private ListNode getGroupEnd(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}