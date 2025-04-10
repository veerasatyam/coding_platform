/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = 0, size2 = 0;
        ListNode curr = headA;
        while (curr != null) {
            size1++;
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            size2++;
            curr = curr.next;
        }

        ListNode big = (size1 > size2) ? headA : headB;
        ListNode small = (size1 > size2) ? headB : headA;

        int diff = Math.abs(size1 - size2);
        while (diff-- > 0) {
            big = big.next;
        }

        while (big != null && small != null) {
            if (big == small) return big;
            big = big.next;
            small = small.next;
        }

        return null;
    }
}
