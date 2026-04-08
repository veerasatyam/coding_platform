class Solution {
    void segregate0and1(int[] arr) {
        int one = 0;
        int zero = 0;
        for(int a : arr){
            if(a == 1) one++;
            else zero++;
        }
        for(int i = 0;i<zero;i++)arr[i] = 0;
        for(int i = zero;i<arr.length;i++)arr[i] = 1;
    }
}
