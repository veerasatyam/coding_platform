import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int nq = queries.length;
        int nd = dictionary.length;
        List<String> result = new ArrayList<>();
        for(String q : queries){
            for(String d : dictionary){
                int diff = helper(q,d);
                if(diff <= 2) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
    private int helper(String a, String b){
        int c = 0;
        for(int i = 0;i<a.length();i++) if(a.charAt(i) != b.charAt(i)) c++;
        return c;
    }
}