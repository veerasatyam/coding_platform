import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                middle.add(num);
            } else {
                right.add(num);
            }
        }
        left.addAll(middle);
        left.addAll(right);

        int[] result = new int[left.size()];
        for (int i = 0; i < left.size(); i++) {
            result[i] = left.get(i);
        }
        return result;
        
    }
}


// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int n=nums.length;
//         int m=0;
//         int[] ans=new int[n];
//         for(int i=0;i<n;i++){
//             if(nums[i]<pivot){
//                 ans[m]=nums[i];
//                 m++;
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(nums[i]==pivot){
//                 ans[m]=nums[i];
//                 m++;
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(nums[i]>pivot){
//                 ans[m]=nums[i];
//                 m++;
//             }
//         }
//         return ans;
//     }
// }

// optimal 2 pointer approach
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans  = new int[n];
        int count = 0;
        int equal = 0;
        for(int i : nums){
            if(i > pivot) count++;
        }
        int i = 0;
        int j = n - count;
        count = j - 1;
        for(int a : nums){
            if(a < pivot) ans[i++] = a;
            else if(a > pivot) ans[j++] = a;
            else ans[count--] = a; 
        }
        return ans;
    }
}