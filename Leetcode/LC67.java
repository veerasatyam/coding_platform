// class Solution {
//     public String addBinary(String a, String b) {
//         int x = to_num(a);
//         int y = to_num(b);
//         int z=x+y;
//         return Integer.toBinaryString(z);
//     }
//     int  to_num(String a)
//     {
//         int sum=0,j=0;
//         for(int i=a.length()-1;i>=0;i--)
//         {
//            if(a.charAt(i)=='1') sum = sum +(int) Math.pow(2, j);
//            j++;
//         }
//         return sum;

//     }
// }
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            carry = sum / 2;
            result.append(sum % 2);
        }
        
        return result.reverse().toString();
    }