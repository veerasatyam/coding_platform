class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Solution {
    public static int maxPalindrome(Node head) {
        Node curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int[] values = new int[size];
        curr = head;
        int i=0;
        while(curr != null)
        {
           values[i] = curr.data;
           i++;
           curr = curr.next;
        }
        int max_length=1;
        for(i=0;i<size;i++){
            for(int j=i;j<size;j++)
            {
                if(isPalindrome(values,i,j)){
                    max_length = Math.max(max_length,j-i+1);
                }
            }
        }
        return max_length;
    }
    public static boolean isPalindrome(int[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}