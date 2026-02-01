class Solution {
    public int countMonobit(int n) {
        int count = 0;
        if(n==0) return 1;
        if(n<=1) return 2;
        count = 2;
        for(int i=2;i<=n;i++){
            if(powerOfTwoMinusOne(i)){
                count++;
            }
        }
        return count;
    }
    private boolean powerOfTwoMinusOne(int num){
        int val = num + 1;
        return (val & (val - 1)) == 0;
    }
}