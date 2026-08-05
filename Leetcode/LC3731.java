class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet< Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a : nums){
            min = Math.min(a,min);
            max = Math.max(a,max);
            set.add(a);
        }
        for(int i = min;i <= max; i++){
            if(!set.contains(i)) result.add(i);
        }
        return result;
    }
}