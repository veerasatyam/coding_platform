/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Solution {
    public Node flatten(Node root) {
       List<Integer> values = new ArrayList<>();
       while (root != null){
        values.add(root.data);
        Node temp = root.bottom;
        while (temp != null){
            values.add(temp.data);
            temp = temp.bottom;
        }
        root = root.next;
       }
       Collections.sort(values);
       Node tail = null;
       Node head = null;
       for(int a : values){
        Node newNode = new Node(a);
        if(head == null) head = newNode;
        else tail.bottom = newNode;
        tail = newNode;
       }
       return head;
    }
}



// using merge sort
/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        if(root  == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = merge(root,root.next);
        return root;
    }
    private static Node merge(Node l1,Node l2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                curr.bottom = l1;
                l1 = l1.bottom;
            }else{
                curr.bottom = l2;
                l2 = l2.bottom;
            }
            curr= curr.bottom;
        }
        if(l1 != null) curr.bottom = l1;
        else curr.bottom = l2;
        return dummy.bottom;
    }
}