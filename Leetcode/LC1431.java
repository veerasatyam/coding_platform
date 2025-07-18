import java.util.ArrayList;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max=0;
        for(int a : candies) max = Math.max(max,a);
        for(int a : candies){
            if(a+extraCandies >=max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}