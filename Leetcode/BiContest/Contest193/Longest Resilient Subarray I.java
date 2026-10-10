// brute force

class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 1;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(isValid(i,j,sum,k,nums)){
                    max = Math.max(max,j - i + 1);
                }
            }
        }
        return max;
    }
    private static boolean isValid(int i,int j,int sum,int k,int[] arr){
        int x = sum;
        for(int a = i; a <= j ;a++){
            x = x - arr[a];
            if(x % k != 0) return false;
            x = x + arr[a];
        }
        return true;
    }
}


// little optimisation
class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 1;
        for(int i = 0; i < n; i++){
            int sum = 0;
            int[] freq = new int[k];
            for(int j = i; j < n; j++){
                sum += nums[j];
                freq[nums[j] % k]++;
                if(freq[sum % k] == j - i + 1){
                    max = Math.max(max,j - i + 1);
                }
            }
        }
        return max;
    }
}