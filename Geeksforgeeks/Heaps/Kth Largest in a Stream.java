class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size() < k){
                ans.add(-1);
                continue;
            }else{
                if(pq.size() > k) pq.poll();
                ans.add(pq.peek());
            }
        }
        return ans;
    }
}