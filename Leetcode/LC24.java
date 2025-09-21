class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode first = curr;        
            ListNode second = curr.next; 
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;       
            curr = first.next;   
        }

        return dummy.next;
    }
}
