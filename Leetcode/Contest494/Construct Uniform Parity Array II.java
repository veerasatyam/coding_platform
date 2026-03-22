class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for (int a : nums1) {
            if (a % 2 == 1) {
                hasOdd = true;
                minOdd = Math.min(minOdd,a);
            }
        }
        if (!hasOdd) return true;
        for (int a : nums1) {
            if (a % 2 == 0 && a < minOdd) return false;
        }
        return true;
    }
}