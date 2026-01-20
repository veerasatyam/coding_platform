class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int curr = nums.get(i);
            result[i] = -1;
            for(int j=0;j<32;j++){
               if ((curr & (1 << j)) != 0) continue;
                int candidate = curr ^ (1<<j-1);
                if((candidate | (candidate+1)) == curr){
                    result[i] = candidate;
                    break;
                }
            }
        }
        return result;
    }
}