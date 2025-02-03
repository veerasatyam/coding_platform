class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int desc = 0, maxdesc = 0;
        int asc = 0, maxasc = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxdesc = Math.max(desc, maxdesc);
                desc = 0;
                asc++;
            } else if (nums[i] < nums[i - 1]) {
                maxasc = Math.max(asc, maxasc);
                asc = 0;
                desc++;
            } else {
                maxasc = Math.max(asc, maxasc);
                maxdesc = Math.max(desc, maxdesc);
                asc = 0;
                desc = 0;
            }
        }

        maxasc = Math.max(asc, maxasc);
        maxdesc = Math.max(desc, maxdesc);

        return Math.max(maxasc, maxdesc) + 1;
    }
}
