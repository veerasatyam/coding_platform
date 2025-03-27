import java.util.HashMap;

class Solution {
    int maxLen(int arr[]) {
       int n = arr.length,ans=0;
       HashMap<Integer,Integer> href = new HashMap<>();
       href.put(0, -1);
       int sum=0;
       for(int i=0;i<n;i++)
       {
        sum = sum + arr[i];
        if(href.containsKey(sum)) 
        {
            int l = i-href.get(sum);
            ans = Math.max(ans, l);
        }else{
            href.put(sum, i);
       }
    }
    return ans;
  }
}