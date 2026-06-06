// 229. Majority Element II
// using Boyer-Moore Majority Vote Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int v1 = 0;
        int v2 = 0;
        int e1 = Integer.MAX_VALUE;
        int e2 = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n;i++){
            if(v1 == 0 && e2 != nums[i]){
                v1++;
                e1 = nums[i];
            }else if(v2 == 0  && e1 != nums[i]){
                v2++;
                e2 = nums[i];
            }else if(e1 == nums[i]) v1++;
            else if(e2 == nums[i]) v2++;
            else{
                v2--;
                v1--;
            }
        }
        int c1 = 0;
        int c2 = 0;
        for(int a : nums){
            if(e1 == a) c1++;
            if(e2 == a) c2++;
        }
        List<Integer> result = new ArrayList<>();
        if(c1 > n / 3) result.add(e1);
        if(c2 > n / 3) result.add(e2);
        return result;
    }
}