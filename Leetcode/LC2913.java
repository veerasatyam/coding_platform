class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        
        int n = nums.size();
        for(int i = 0; i < n; i++){
            Set<Integer> uniqueCounts = new HashSet<>();
            for(int j = i; j < n; j++){
                uniqueCounts.add(nums.get(j));
                totalSum += (uniqueCounts.size() * uniqueCounts.size());
            }
        }
        return totalSum;
    }
}