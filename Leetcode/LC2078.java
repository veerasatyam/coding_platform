class Solution {
    public int maxDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                if(nums[i] != nums[j]) max = Math.max(max,Math.abs(j-i));
            }
        }
        return max;
    }
}


// two pointers approach
class Solution {
    public int maxDistance(int[] colors) {
       int dis = 0;
       int n = colors.length;
       for(int i=0;i<n-1;i++){
        if(colors[i] != colors[n-1]){
            dis = Math.max(dis ,(n-1)-i);
            break;
        }
       }
      
       for(int i=n-1;i>=1;i--){
        if(colors[0]!=colors[i]){
         dis = Math.max(dis,i);
            }
       }
       return dis;
    
    }
}