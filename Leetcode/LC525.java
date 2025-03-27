class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length,ans=0;
        for(int i=0;i<n;i++) if(nums[i]==0) nums[i]=-1;
        HashMap<Integer,Integer> href = new HashMap<>();
        href.put(0, -1);
        int sum=0;
        for(int i=0;i<n;i++)
        {
         sum = sum + nums[i];
         if(href.containsKey(sum)) 
         {
             int l = i-href.get(sum);
             ans = Math.max(ans, l);
         }else{
             href.put(sum, i);
        }
     }
     return ans;
    }
}