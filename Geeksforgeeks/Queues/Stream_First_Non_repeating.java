import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String FirstNonRepeating(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for(char x : s.toCharArray())
        {
             q.add(x);
             if(hm.containsKey(x))
             {
                hm.put(x,hm.getOrDefault(x,0)+1);
             }
             else{
                hm.put(x,1);
             }
             while(q.size()>0 && hm.get(q.peek())>1) q.poll();
             if(q.size()>0) str.append(q.peek());
             else str.append("#");
        }
        return str.toString();
    }
}