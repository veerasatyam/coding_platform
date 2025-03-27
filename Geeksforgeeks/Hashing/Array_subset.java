
import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {
         HashMap<Integer,Integer> href = new HashMap<>();
         for(int x : a) href.put(x,href.getOrDefault(x, 0)+1);
         for(int x : b)
         {
            if(href.containsKey(x) && href.get(x)>0)
            {
               href.put(x, href.getOrDefault(x, 0)-1);
            }
            else return false;
         }
         return true;
    }
}