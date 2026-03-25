/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count = 0;
    public int countAllPaths(Node root, int k) {
        HashMap<Long,Integer> map = new HashMap<>();
        countPaths(root,0,k,map)
        return count;
    }
    private int countPaths(Node root,int curr,int k,HashMap<Long,Integer> map){
        if(root == 0) return 0;
    }
}