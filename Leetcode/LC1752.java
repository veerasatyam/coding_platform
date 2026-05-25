class Solution {
    public boolean check(int[] nums) {
       int n = nums.length;
       int count = 1;
       for(int i=1;i<2*n;i++)
       {
        if(nums[(i-1)%n]<=nums[i%n]) count++;
        else count =1;
        if(count==n) return true;
       }
        return n==1;
    }
}

class Solution {
    public boolean check(int[] nums) {
        int drops = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                drops++;
            }
        }
        return drops <= 1;
    }
}
