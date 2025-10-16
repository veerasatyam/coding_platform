class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        int i = 0;
        while (true) {
            int rem = i % value;
            if (map.getOrDefault(rem, 0) == 0) {
                return i;
            }
            map.put(rem, map.get(rem) - 1);
            i++;
        }
    }
}



class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mp = new int[value];
        for (int x : nums) {
            int v = ((x % value) + value) % value;
            mp[v]++;
        }
        int mex = 0;
        while (mp[mex % value] > 0) {
            mp[mex % value]--;
            mex++;
        }
        return mex;
    }
}