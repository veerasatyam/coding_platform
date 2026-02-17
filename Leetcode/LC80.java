class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int index = 0;
        int n = nums.length;
        int i = 0,j=0;
        while(i<n){
            int count = 0;
            while(j<n && nums[i] == nums[j]){
                count++;
                j++;
            }
            if(count > 1){
                nums[index++] = nums[i];
                nums[index++] = nums[i];
            } else {
                nums[index++] = nums[i];
            }
            i = j;
        }
        return index;
    }
}



// anotger approach
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int index = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i<2 || nums[i]!=nums[index-2]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}