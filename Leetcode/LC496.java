class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0;i<nums1.length; i++)indexMap.put(nums1[i], i);
        for (int a : nums2) {
            while (!stack.isEmpty() && stack.peek() < a) {
                int val = stack.pop();
                result[indexMap.get(val)] = a;
            }
            if(indexMap.containsKey(a))stack.push(a);
        }
        return result;
    }
}


//another approach 
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []ans = new int[nums1.length];
        for ( int i =0 ; i< nums1.length;i++){
            ans[i]=-1;
            for(int j =0 ;j< nums2.length ;j++){
                if(nums1[i]==nums2[j]){
                    for (int k = j+1 ; k<nums2.length ; k++)
                    if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                    }
                     break ;
                }
                
            }
        }
        return ans ;
    }
}