class Solution {
    static List<String> result = new ArrayList<>();
    static String[] wordBreak(String[] dict, String s) {
        Set<String> dic = new HashSet<>(Arrays.asList(dict));
        helper(0,s,dic,"");
        return result.toArray(new String[0]);
    }

    private static void helper(int index,String s,Set<String> dic,String curr){
        if(index == s.length()) {
            result.add(curr);
            return;
        }
        for(int i = index;i < s.length();i++){
            String word = s.substring(index,i + 1);
            if(dic.contains(word)){
                String prev = curr;
                if(!curr.isEmpty()) curr += " ";
                curr = curr + word;
                helper(i + 1, s, dic, curr);
                curr = prev;
            }
        }
    }
}

// memoization 
class Solution {
    static List<String> result = new ArrayList<>();
    static String[] wordBreak(String[] dict, String s) {
        Set<String> dic = new HashSet<>(Arrays.asList(dict));
        HashMap<Integer,List<String>> dp = new HashMap<>();
        result = helper(0,s,dic,dp);
        return result.toArray(new String[0]);
    }

    private static List<String> helper(int index,String s,Set<String> dic,HashMap<Integer,List<String>> dp){
        if(dp.containsKey(index)) return dp.get(index);
        List<String> curr = new ArrayList<>();
        if(index == s.length()){
            curr.add("");
            return curr;
        }
        for(int i = index;i < s.length();i++){
            String word = s.substring(index,i + 1);
            if(dic.contains(word)){
                List<String> next = helper(i + 1,s,dic,dp);
                for(String str : next){
                    if(str.isEmpty()) curr.add(word);
                    else curr.add(word + " " + str);
                }
            }
        }
        dp.put(index,curr);
        return curr;
    }
}