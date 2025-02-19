class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            char x = words[i].charAt(words[i].length() - 1);
            int y = Character.getNumericValue(x);
            result[y - 1] = words[i].substring(0, words[i].length() - 1); 
        }

        return String.join(" ", result);
    }
}

