class Solution {
    public int smallestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int min = Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j < n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
            while(i < n && map.size() == 3){
                min = Math.min(min,j-i+1);
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) - 1);
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}







class Solution {
    public int smallestSubstring(String s) {
        int min = Integer.MAX_VALUE;
        int[] count = new int[3];
        int i = 0, j = 0;
        int n = s.length();
        while (j < n) {
            count[s.charAt(j) - '0']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                min = Math.min(min, j - i + 1);
                count[s.charAt(i) - '0']--;
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}