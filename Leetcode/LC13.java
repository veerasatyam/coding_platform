
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X',10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int sum =0;
        for(int i=0;i<s.length()-1;i++)
        {
            char x = s.charAt(i);
            if(hm.get(x)<hm.get(s.charAt(i+1)))
            {
                int a = Math.abs(hm.get(x)-hm.get(s.charAt(i+1)));
                sum = sum + a ;
                i++;
            }
            else{
                sum += hm.get(x);
            }
        }
    }
}