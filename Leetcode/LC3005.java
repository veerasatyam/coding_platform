class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for(int a : nums) {
            freq[a]++;
            max = Math.max(freq[a],max);
        }
        int count=0;
        for(int x : freq) if(x==max) count = count + x;
        return count;
    }
}