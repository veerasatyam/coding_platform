class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int curr = 0;
            for(int j=0;j<n;j++){
                if(nums[j]<nums[i]){
                    curr++;
                }
            }
            ans[i]=curr;
        }
        return ans;
    }
}



// optimal solution
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] freq = new int[101];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<=100;i++){
            freq[i]+=freq[i-1];
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ans[i]=0;
            }else{
                ans[i]=freq[nums[i]-1];
            }
        }
        return ans;
    }
}