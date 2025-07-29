import java.util.HashMap;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String word : strs){
            char[] sortedarr = word.toCharArray();
            Arrays.sort(sortedarr);
            String str = new String(sortedarr);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            result.add(group);
        }
        return result;
    }
}