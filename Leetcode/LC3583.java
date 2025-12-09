import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> L=new HashMap<>();
        HashMap<Integer,Integer> R=new HashMap<>();
        for(int x:nums) R.put(x,R.getOrDefault(x,0)+1);
        final int MOD=1_000_000_007;
        long count=0;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            R.put(curr,R.get(curr)-1);
            long target=(long)curr*2;
            if(target<=Integer.MAX_VALUE){
                long left=L.getOrDefault((int)target,0);
                long right=R.getOrDefault((int)target,0);
                count=(count+(left%MOD)*(right%MOD))%MOD;
            }
            L.put(curr,L.getOrDefault(curr,0)+1);
        }
        return (int)count;
    }
}
