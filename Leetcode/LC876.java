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
    public ListNode middleNode(ListNode head) {
        ListNode tortuise = head;
        ListNode rabbit = head ;
        while (rabbit != null && rabbit.next != null)
        {
            tortuise = tortuise.next;
            rabbit = rabbit.next.next;
        }
        return tortuise;
    }
}