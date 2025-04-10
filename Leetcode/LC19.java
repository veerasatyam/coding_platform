class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        
        if (fast == null) {
            return head.next;
        }
        
        ListNode temp = null;
        
        while (fast != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        temp.next = slow.next;
        slow.next = null;
        
        return head;
    }
}
