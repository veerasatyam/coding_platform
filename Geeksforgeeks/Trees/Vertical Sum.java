/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

// Time Complexity: O(n log n) due to TreeMap operations
// Space Complexity: O(n) for the map and recursion stack
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Helper(root, 0, map);
        for (int sum : map.values()) {
            ans.add(sum);
        }
        return ans;
    }
    private static void Helper(Node root,int hd,Map<Integer,Integer> map){
        if(root == null) return;
        map.put(hd,map.getOrDefault(hd,0) + root.data);
        Helper(root.left,hd - 1,map);   
        Helper(root.right,hd + 1,map);
    }
}




// optimal solution using hashmap and min max to avoid sorting
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        int[] minMax = new int[2]; // minMax[0] for min, minMax[1] for max
        Helper(root, 0, map, minMax);
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            ans.add(map.getOrDefault(i, 0));
        }
        return ans;
    }
    private static void Helper(Node root,int hd,Map<Integer,Integer> map,int[] minMax){
        if(root == null) return;
        map.put(hd,map.getOrDefault(hd,0) + root.data);
        minMax[0] = Math.min(minMax[0], hd);
        minMax[1] = Math.max(minMax[1], hd);
        Helper(root.left,hd - 1,map,minMax);   
        Helper(root.right,hd + 1,map,minMax);
    }
}