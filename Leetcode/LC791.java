class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<order.length();i++) map.put(order.charAt(i),i);
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        Collections.sort(chars, (a, b) -> {
            boolean inA = map.containsKey(a);
            boolean inB = map.containsKey(b);
            if (inA && inB) {
                return map.get(a) - map.get(b);
            } else if (inA) {
                return -1; 
            } else if (inB) {
                return 1; 
            } else {
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}









class Solution {
  public String customSortString(final String order, final String s) {
    StringBuilder sb = new StringBuilder();
    int[] count = new int[128];
    for (final char c : s.toCharArray()) count[c]++;
    for (final char c : order.toCharArray())
      while (count[c]-- > 0)
        sb.append(c);
    for (char c = 'a'; c <= 'z'; ++c)
      while (count[c]-- > 0)
        sb.append(c);
    return sb.toString();
  }
}