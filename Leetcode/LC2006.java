import java.util.HashMap;

class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (freqMap.containsKey(num + k)) {
                count += freqMap.get(num + k);
            }
            if (freqMap.containsKey(num - k)) {
                count += freqMap.get(num - k);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}


// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
//         for(int i:nums) hash.put(i,hash.getOrDefault(i,0)+1);
//         int count = 0;
//         for(int i=0;i<nums.length;i++){
//             if(hash.containsKey(nums[i]+k)) count+=hash.get(nums[i]+k);
//         }
//         return count;
//     }
// }