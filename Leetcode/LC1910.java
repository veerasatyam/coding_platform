class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder(s);
        while(result.indexOf(part) != -1)
        {
            result = result.delete(result.indexOf(part), result.indexOf(part)+part.length());
        }
        return result.toString();
    }
}