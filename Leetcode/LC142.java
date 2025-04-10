public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                ListNode s1 = head;
                ListNode s2 = slow;
                
                while (s1 != s2) {
                    s1 = s1.next;
                    s2 = s2.next;
                }
                
                return s1;
            }
        }
        
        return null;
    }
}
