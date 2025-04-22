class Solution {
    public int countSegments(String s) {
        int cnt=0;
        String arr[]=s.split(" ");
       for(String word:arr){
        if(!word.isEmpty()){
            cnt++;
        }
       }
       return cnt;
    }
}