class Solution {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(Character.isDigit(x))
            {
                result.deleteCharAt(result.length()-1);
            }
            else
            {
                result.append(x);
            }
        }
        return result.toString();
    }
}