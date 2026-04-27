class Solution {
    public long smallestNumber(long num) {
        boolean signed = num > 0 ? false : true;
        if(signed){
            num = num * -1;
            char[] chars = String.valueOf(num).toCharArray();
            Arrays.sort(chars); 
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
            String result = new String(chars);
            return Long.parseLong(result) * -1;
        }
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        int idx = 0;
        while(chars[idx] == '0') idx++;
        String result = new String(chars);
        result = result.substring(idx,idx+1) + result.substring(0,idx) + result.substring(idx+1);
        return Long.parseLong(result);
    }
}