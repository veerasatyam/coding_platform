class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int max = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < n){
            map.put(arr[j],map.getOrDefault(arr[j],0) + 1);
            while(map.get(arr[j]) > k){
                map.put(arr[i],map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            max = Math.max(max,j - i + 1);
            j++;
        }
        return max;
    }
}