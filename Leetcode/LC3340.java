class Solution {
    public boolean isBalanced(String num) {
        int even =0,odd=0;
       for(int i=0;i<num.length();i++)
       {
         int x = Character.getNumericValue(num.charAt(i));
         if(i%2==0) even += x;
         else odd += x;
       }
       return even==odd;
    }
}