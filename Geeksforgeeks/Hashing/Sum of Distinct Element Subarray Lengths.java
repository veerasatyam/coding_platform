class Solution {
    public int sumOfLengths(int arr[]) {
        Set<Integer> s = new HashSet<>();
        int n = arr.length;
        int j = 0, ans = 0;
        for (int i = 0; i < n; i++){
            while (j < n && !s.contains(arr[j])){
                s.add(arr[j]);
                j++;
            }
            ans += ((j - i) * (j - i + 1)) / 2;
            s.remove(arr[i]);
        }

        return ans;
    }
}
