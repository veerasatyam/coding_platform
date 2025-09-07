class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int i=0,j=n-1;
        int x=1;
        while(i<j){
            result[i++]=x;
            result[j++]=-x;
            x++;
        }
        if(n%2==1) result[i+1] = 0;
        return result;
    }
}