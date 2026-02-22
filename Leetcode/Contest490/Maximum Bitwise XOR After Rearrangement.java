class Solution {
    public String maximumXor(String s, String t) {
        int one_t = 0;
        int zero_t = 0;
        for (char c : t.toCharArray()) {
            if (c == '1') one_t++;
            else zero_t++;
        }
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c=='1'){
                if(zero_t>0){
                    result.append('1');
                    zero_t--;
                }else{
                    result.append('0');
                    one_t--;
                }
            }else{
                if(one_t>0){
                    result.append('1');
                    one_t--;
                }else{
                    result.append('0');
                    zero_t--;
                }
            }
        }
        return result.toString();
    }
}