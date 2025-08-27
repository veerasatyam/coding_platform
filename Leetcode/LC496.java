class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> MDstack = new Stack<>();
        HashMap<Integer,Integer> nextGreatest = new HashMap<>();
        for(int num : nums2){
            while (!MDstack.isEmpty() && MDstack.peek() < num) {
                nextGreatest.put(MDstack.pop(), num);
            }
            MDstack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreatest.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}