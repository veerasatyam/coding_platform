// pure recursion
class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums,0,nums.length-1,0,0,true);
    }
    private boolean helper(int[] nums,int start,int end,int player1,int player2,boolean turn){
        if(start > end){
            return player1 >= player2;
        }
        if(turn) {
            return helper(nums,start+1,end,player1+nums[start],player2,!turn) || helper(nums,start,end-1,player1+nums[end],player2,!turn);
        }else{
            return helper(nums,start+1,end,player1,player2+nums[start],!turn) && helper(nums,start,end-1,player1,player2+nums[end],!turn);
        }
    }
}

//memoization
class Solution {
    HashMap<String,Boolean> memo = new HashMap<>();
    public boolean predictTheWinner(int[] nums){
        return helper(nums,0,nums.length-1,0,0,true);
    }
    private boolean helper(int[] nums,int start,int end,int player1,int player2,boolean turn){
        String key = start + "," + end + "," + player1 + "," + player2 + "," + turn;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(start > end){
            return player1 >= player2;
        }
        if(turn) {
            memo.put(key, helper(nums,start+1,end,player1+nums[start],player2,!turn) || helper(nums,start,end-1,player1+nums[end],player2,!turn));
            return memo.get(key);
        }else{
            memo.put(key, helper(nums,start+1,end,player1,player2+nums[start],!turn) && helper(nums,start,end-1,player1,player2+nums[end],!turn));
            return memo.get(key);
        }
    }
}



// other approach which are more efficient
class Solution{
    public boolean predictTheWinner(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        int score = helper(nums,0,n-1,true);
        return score >= sum - score;
    }
    private int helper(int[] nums,int i,int j,boolean turn){
        if(i > j) return 0;
        if(turn){
            return Math.max(nums[i] + helper(nums,i+1,j,!turn), nums[j] + helper(nums,i,j-1,!turn));
        }else{
            return Math.min(helper(nums,i+1,j,!turn), helper(nums,i,j-1,!turn));
        }
    }
}


// recursion + memoization
class Solution{
    HashMap<String,Integer> memo = new HashMap<>();
    public boolean predictTheWinner(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        int score = helper(nums,0,n-1,true);
        return score >= sum - score;
    }
    private int helper(int[] nums,int i,int j,boolean turn){
        String key = i + "," + j + "," + turn;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(i > j) return 0;
        if(turn){
            memo.put(key, Math.max(nums[i] + helper(nums,i+1,j,!turn), nums[j] + helper(nums,i,j-1,!turn)));
            return memo.get(key);
        }else{
            memo.put(key, Math.min(helper(nums,i+1,j,!turn), helper(nums,i,j-1,!turn)));
            return memo.get(key);
        }
    }
}