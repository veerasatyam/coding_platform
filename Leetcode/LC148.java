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
    public ListNode sortList(ListNode head) {
        return Mergesort(head);
    }

    ListNode Mergesort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode m = mid(head);
        ListNode nextToMid = m.next;
        m.next = null;
        ListNode left = Mergesort(head);
        ListNode right = Mergesort(nextToMid);

        return Merge(left, right);
    }

    ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode h, t;

        if (list1.val < list2.val) {
            h = t = list1;
            list1 = list1.next;
        } else {
            h = t = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                t.next = list1;
                list1 = list1.next;
            } else {
                t.next = list2;
                list2 = list2.next;
            }
            t = t.next;
        }

        t.next = (list1 != null) ? list1 : list2;

        return h;
    }
}
