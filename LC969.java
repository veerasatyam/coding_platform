class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int curr = n;curr>1;curr--) {
            int idx = find(arr, curr);
            if (idx==curr-1) continue;
            if (idx != 0) {
                flip(arr, idx);
                res.add(idx + 1);
            }
            flip(arr, curr - 1);
            res.add(curr);
        }
        return res;
    }
    private int find(int[] arr,int target) {
        for (int i = 0;i<arr.length;i++)if(arr[i] == target) return i;
        return -1;
    }
    private void flip(int[] arr,int end) {
        int i = 0;
        while (i<end) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            i++;
            end--;
        }
    }
}
