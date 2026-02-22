import java.util.*;

class Solution {
    Map<String,Integer> memo=new HashMap<>();
    public int countSequences(int[] nums,long k){
        return dfs(nums,0,1L,1L,k);
    }
    private int dfs(int[] nums,int index,long num,long den,long k){
        long g = gcd(num,den);
        num /= g;
        den /= g;
        if(index == nums.length){
            return (den==1 && num==k) ? 1:0;
        }
        String key=index + "," + num + "," +den;
        if(memo.containsKey(key)) return memo.get(key);
        int ways=0;
        long val=nums[index];
        ways+=dfs(nums,index+1,num*val,den,k);
        ways+=dfs(nums,index+1,num,den*val,k);
        ways+=dfs(nums,index+1,num,den,k);
        memo.put(key,ways);
        return ways;
    }
    private long gcd(long a,long b){
        if(b==0) return Math.abs(a);
        return gcd(b,a%b);
    }
}