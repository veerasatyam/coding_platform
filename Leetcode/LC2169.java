class Solution {
    public int countOperations(int num1, int num2) {
        int i=0;
        int a = num1,b=num2;
        while(!(a==0 || b==0)){
            if(a>=b) a = a-b;
            else b = b-a;
            i++;
        }
        return i;
    }
}