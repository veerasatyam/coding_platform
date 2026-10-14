class Solution {
    public long maxAlternatingSum(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.offer(Math.abs(num));
        }
        long sum = 0;
        int n = nums.length;
        int k = n % 2 == 0 ? n / 2 : n / 2 + 1;
        while(k-- > 0){
            int x = pq.poll();
            sum += (x * x);
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            sum -= (x * x);
        }
        return sum;
    }
}


// another approach
class Solution {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n / 2; i++) ans -= nums[i];
        for (int i = n / 2; i < n; i++) ans += nums[i];
        return ans;
    }
}