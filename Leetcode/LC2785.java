class Solution {
    public String sortVowels(String s) {
        String vowelCheck = "AEIOUaeiou";    
        int count = 0; 
        for(int i=0;i<s.length();i++)  if(vowelCheck.contains(s.charAt(i) + "")) count++; 
        char[] vows = new char[count];  
        int ind = 0; 
        for(int i=0;i<s.length();i++) if(vowelCheck.contains(s.charAt(i) + "")) vows[ind++] = s.charAt(i); 
        Arrays.sort(vows);   
        ind = 0;
        char res[] = s.toCharArray();  
        for(int i=0;i<s.length();i++) 
        {
            if(vowelCheck.contains(res[i] + "")) res[i] = vows[ind++];   
        } 
        return String.valueOf(res); 
    }
}