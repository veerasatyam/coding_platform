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
        if(lists == null || lists.length == 0) return null;
        return mergeSort(lists,0,lists.length - 1);
    }
    private static ListNode mergeSort(ListNode[] lists,int low,int high){
        if(low == high) return lists[low];
        int mid = (low + high) / 2;
        ListNode h1 = mergeSort(lists,low,mid);
        ListNode h2 = mergeSort(lists,mid + 1,high);
        return merge(h1,h2);
     }
     static ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        else curr.next = l2;
        return dummy.next;
     }
} 