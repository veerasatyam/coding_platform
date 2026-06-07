import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num:nums) hs.add(num);
        int count=0;
        for(Integer k : hs){
            if(!hs.contains(k-1)){
              int c=1;
              while(hs.contains(k+c))c++;
              count = Math.max(c, count);
            }
        }
        return count;
    }
}