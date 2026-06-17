// User function Template for Java//User function Template for Java

// bit masking

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
       int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int mask = 0; mask < (i << n); mask++){
            int sum = 0;
            for(int i = 0;i < n;i++){
                if((mask & (1 << i)) != 0) sum += arr[i];
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        return ans;
    }
}


// using recusion
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0,0,arr,ans);
        Collections.sort(ans);
        return ans;
    }
    public static void helper(int index,int curr,int[] arr,ArrayList<Integer> ans){
        if(index == arr.length){
            ans.add(curr);
            return;
        }
        helper(index + 1,curr + arr[index],arr,ans);
        helper(index + 1,curr,arr,ans);
    }
}