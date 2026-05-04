class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
       ArrayList<Integer> list = new ArrayList<>();
       for(int a : arr) list.add(a);
       Collections.sort(list,(a,b) ->{
           if(count(a) == count(b)) return 0;
           return count(a) > count(b) ? -1 : 1;
       });
       return list;
    }
    private int count(int n){
        int c = 0;
        while(n != 0){
            if((n & 1) == 1) c++;
            n = n >> 1;
        }
        return c;
    }
}