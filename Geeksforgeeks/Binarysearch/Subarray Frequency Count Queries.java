import java.util.List;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i]))map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] q : queries){
            int l = q[0], r = q[1], x = q[2];
            if(!map.containsKey(x)){
                ans.add(0);
                continue;
            }
            List<Integer> list = map.get(x);
            int left = 0;
            int right = list.size()-1;
            while(left <= rigth){
                int mid = left + (right - left)/2;
                if(list.get(mid) < l) left = mid + 1;
                else right = mid - 1;
            }
            int leftIndex = left;
            left = 0;
            right = list.size()-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(list.get(mid) <= r) left = mid + 1;
                else right = mid - 1;
            }
            int rightIndex = right;
            ans.add(rightIndex - leftIndex + 1);
        }
        return ans;
    }
}