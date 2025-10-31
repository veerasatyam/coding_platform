class Solution {
    public int[] getSneakyNumbers(int[] nums) {
         int[] result = new int[2];
         HashSet<Integer> set = new HashSet<>();
         for(int a : nums){
            if(!set.add(a)) {
                result[i] = a;
                i++;
            } 
         }
         return result;
    }
}

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        int[] result = new int[2];
        int index = 0;
        
        for (int num : nums) {
            if (++freq[num] == 2) {
                result[index++] = num;
                if (index == 2) break;
            }
        }
        return result;
    }
}
