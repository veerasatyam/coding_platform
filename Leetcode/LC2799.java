import java.util.HashSet;
// brute force
// class Solution {
//     public int countCompleteSubarrays(int[] nums) {
//         int n = nums.length;
//         HashSet<Integer> hs = new HashSet<>();
//         for (int num : nums) {
//             hs.add(num);
//         }
//         int k = hs.size();

//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             HashSet<Integer> currentSet = new HashSet<>();
//             for (int j = i; j < n; j++) {
//                 currentSet.add(nums[j]);
//                 if (currentSet.size() == k) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet <Integer> hs = new HashSet<>() ; 
        for(int num : nums){
            hs.add(num) ; 
        }
        HashMap <Integer, Integer> hm = new HashMap <>() ; 
        int k = hs.size() ; 
        int l = 0 ; 
        int result = 0 ; 
        for(int r=0; r<nums.length; r++ ){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1) ;
            while(hm.size() == k){
                result += nums.length-r ;
                hm.put(nums[l], hm.get(nums[l])-1 ) ;
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]) ; 
                }
                l++ ; 
            }
        }
        return result; 
        
    }
}