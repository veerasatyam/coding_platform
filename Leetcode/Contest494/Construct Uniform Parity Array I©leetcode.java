class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = 0;
        int even = 0;
        for(int a : nums1){
            if(a % 2 == 0) even++;
            else odd++;
        }
        return odd != 0 && even != 0;
    }
}