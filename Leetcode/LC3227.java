// class Solution {
//     public boolean doesAliceWin(String s) {
//          String vowelCheck = "aeiou"; 
//          int count=0;
//          for(char a : s.toCharArray) if(vowelCheck.contains(a+"")) count++;
//          if(count==0) return false;
//          return true;
//     }
// }

class Solution {
    public boolean doesAliceWin(String s) {
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i);
            if(ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u') return true;

        } return false;
    }
}