class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int a : nums){
            if(a==0)z++;
            if(a==1)o++;
            if(a==2)t++;
        }
        for(int i=0;i<z;i++)nums[i]=0;
        for(int i=z;i<o+z;i++)nums[i]=1;
        for(int i=o+z;i<nums.length;i++)nums[i]=2;
    }
}