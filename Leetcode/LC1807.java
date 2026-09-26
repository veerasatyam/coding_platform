class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for (List<String> x : knowledge) map.put(x.get(0), x.get(1));
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                StringBuilder curr = new StringBuilder();
                while (s.charAt(i) != ')') {
                    curr.append(s.charAt(i));
                    i++;
                }
                String key = curr.toString();
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }
                i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}