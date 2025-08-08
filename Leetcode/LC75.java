// class Solution {
//     public void sortColors(int[] nums) {
//         int z=0,o=0,t=0;
//         for(int a : nums){
//             if(a==0)z++;
//             if(a==1)o++;
//             if(a==2)t++;
//         }
//         for(int i=0;i<z;i++)nums[i]=0;
//         for(int i=z;i<o+z;i++)nums[i]=1;
//         for(int i=o+z;i<nums.length;i++)nums[i]=2;
//     }
// }

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}
