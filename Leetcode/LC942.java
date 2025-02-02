class Solution {
    public int[] diStringMatch(String s) {
        int[] a = new int[s.length()+1];
        int low = 0;
        int high = s.length();

        for(int i=0;i<s.length();i++)
        {
           char x = s.charAt(i);
           if(x=='I')
           {
            a[i] = low++;
           }
           else{
            a[i]= high--;
           }
        }
        a[s.length()] = low; 
        return a;
    }
}