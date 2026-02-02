class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<n;i++){
            pq.add(nums[i]);
        }
        int totalCost = nums[0] + pq.poll() + pq.poll();
        return totalCost;
    }
}

// another approach
class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            }else if(nums[i] < secondMin){
                secondMin = nums[i];
            }
        }
        return nums[0] + firstMin + secondMin;
    }
}