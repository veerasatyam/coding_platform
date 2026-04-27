class Solution {
    public int generateKey(int num1, int num2, int num3) {
       String a = String.valueOf(num1);
        if (a.length() < 4) a = "0".repeat(4 - a.length()) + a;
        String b = String.valueOf(num2);
        if(b.length() < 4) b = "0".repeat(4-b.length()) + b;
        String c = String.valueOf(num3);
        if(c.length() < 4) c =  "0".repeat(4-c.length()) + c;
        StringBuilder key = new StringBuilder();
        for(int i =0;i<4;i++){
            key.append(String.valueOf(Math.min(a.charAt(i)-'0',Math.min(b.charAt(i)-'0',c.charAt(i)-'0'))));
        }
        return Integer.parseInt(key.toString());
    }
}





class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans=0;
        int place=1;
        for(int i=0;i<4;i++){
            int dig1=num1%10;
            int dig2=num2%10;
            int dig3=num3%10;
            int min=Math.min(dig1,Math.min(dig2,dig3));
            ans+=min*place;
            num1/=10;
            num2/=10;
            num3/=10;
            place=place*10;
        }
        return ans;
    }
}