class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int x : nums) list.add(String.valueOf(x));
        Collections.sort(list,(a,b)->{
            int i=0,j=0;
           while (i < a.length() && j < b.length()) {
                if (a.charAt(i) != b.charAt(j)) {
                    return b.charAt(j) - a.charAt(i);
                }
                i++;
                j++;
            }
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        if(list.get(0).equals("0")) return "0";
        StringBuilder str = new StringBuilder();
        for(String s : list) str.append(s);
        return str.toString();
    }
}
