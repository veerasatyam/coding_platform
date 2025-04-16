/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/

import java.util.ArrayList;

public static ArrayList<Integer> displayList(Node head) {
    ArrayList<Integer> list = new ArrayList<>();
    Node curr = head;

    while (curr != null) {
        list.add(curr.data);
        curr = curr.next;
    }

    return list;
}
