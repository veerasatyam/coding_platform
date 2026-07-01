// Z Algorithm
class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        String s = pattern + $ + text;
        ArrayList<Integer> zArray = zFunction(s);
        ArrayList<Integer> pos = new ArrayList<>();
        int m = pattern.length();
        for(int i = m + 1; i < zArray.size(); i++){
            if(zArray.get(i) == m){
                pos.add(i - m - 1);
            }
        }
        return pos;
    }
    private static ArrayList<Integer> zFunction(String s){
        int n = s.length();
        ArrayList<Integer> z = new ArrayList<>();
        for(int i = 0; i < n; i++) z.add(0);
        int l = 0;
         int r = 0;
         for(int i = 1;i < n; i++){
            if(i <= r){
                int k = i - l;
                z.set(i,Math.min(r - i + 1,z.get(k)));
            }
             while (i + z.get(i) < n && s.charAt(z.get(i)) == s.charAt(i + z.get(i))){
                z.set(i, z.get(i) + 1);
            }
            if (i + z.get(i) - 1 > r) {
                l = i;
                r = i + z.get(i) - 1;
            }
         }
         return z;
    }
}