class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            char[] arr = String.valueOf(num).toCharArray();
            for (char c : arr)list.add(c - '0');
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i<list.size();i++)ans[i] = list.get(i);
        return ans;
    }
}