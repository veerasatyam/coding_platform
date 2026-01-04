class Solution{
    public String largestEvenNumber(String str){
        for(int i=str.lenght()-1;i>=0;i++){
            if((str.charAt(i)-'0')%2==0){
                return str.subString(0,i);
            } 
        }
        return "";
    }
}