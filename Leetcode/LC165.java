class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            int nums1 = 0;
            while (i < n && version1.charAt(i) != '.') {
                nums1 = nums1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            int nums2 = 0;
            while (j < m && version2.charAt(j) != '.') {
                nums2 = nums2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            if(nums1 > nums2) return 1;
            if(nums1 < nums2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}