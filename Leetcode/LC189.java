class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int n = nums.length;
        if(n==k) return;
        int[] temp new int[n];
        for(int i=0;i<n;i++){
            temp[(i+k)%n] = nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}



// without extra space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        reverse(n-k,n,nums);
        reverse(0,n-k,nums);
        reverse(0,n,nums);
    }
    private void reverse(int x,int y,int[] nums){
        int i = x, j = y-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}