// this is not fully optimised...

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for(int i=0;i<len;i++) st.add(wordList.get(i));
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            List<String> x = q.peek();
            q.remove();
            if(x.size()>level){
                level++;
                for(String it : usedOnLevel){
                    st.remove(it);
                }
            }
            String word = x.get(x.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0) ans.add(x);
                else if(ans.get(0).size()==x.size()) ans.add(x);
            }
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] replace = word.toCharArray();
                    replace[i] = ch;
                    String replaceWord = new String(replace);
                    if(st.contains(replaceWord)==true){
                        x.add(replaceWord);
                        List<String> temp = new ArrayList<>(x);
                        q.add(temp);
                        usedOnLevel.add(replaceWord);
                        x.remove(x.size()-1);
                    }
                }
            }
           
        }
         return ans;
    }
}