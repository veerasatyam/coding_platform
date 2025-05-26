import java.util.ArrayList;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].indexOf(x)!=-1) result.add(i);
        }
        return result;
    }
}