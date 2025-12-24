class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for(int a : apple) sum += a;
        int i=capacity.length-1;
        int capSum = 0;
        while(i>=0){
            capSum += capacity[i];
            i--;
            if(capSum>=sum) break;

        }
        return capacity.length-1-i;
    }
}