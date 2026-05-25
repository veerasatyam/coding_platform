class Solution {
    public int coin(int[] arr) {
       int i = 0;
       int j = arr.length - 1;
       while(i < j){
           if(arr[j] < arr[i]) i++;
           else j--;
       }
       return arr[i];
    }
}