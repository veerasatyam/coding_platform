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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return Mergesort(lists, 0, lists.length - 1);
    }

    public ListNode Mergesort(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        int mid = (s + e) / 2;
        ListNode h1 = Mergesort(lists, s, mid);
        ListNode h2 = Mergesort(lists, mid + 1, e);
        return Merge(h1, h2);
    }

    ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode h = null;
        ListNode t = null;

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
