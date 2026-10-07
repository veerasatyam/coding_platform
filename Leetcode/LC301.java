class Solution {
    static List<String> result = new ArrayList<>();
    static int max = 0;
    public List<String> removeInvalidParentheses(String s) {
        result.clear();
        max = 0;
        HashSet<String> set = new HashSet<>();
        helper(0,0,new StringBuilder(),s,set);
        for(String str : set){
            if(str.length() == max){
                result.add(str);
            }
        }
        return result;
    }
    private static void helper(int idx, int count,StringBuilder sb,String s,HashSet<String> set){
        if(idx == s.length()){
            if(count == 0){
                max = Math.max(max,sb.length());
                set.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(idx);
        if(ch == '('){
            sb.append(ch);
            helper(idx+1,count+1,sb,s,set);
            sb.deleteCharAt(sb.length()-1);
            helper(idx+1,count,sb,s,set);
        }
        else if(ch == ')'){
            if(count > 0){
                sb.append(ch);
                helper(idx+1,count-1,sb,s,set);
                sb.deleteCharAt(sb.length()-1);
            }
            helper(idx+1,count,sb,s,set);
        }
        else{
            sb.append(ch);
            helper(idx+1,count,sb,s,set);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}