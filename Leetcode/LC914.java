class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int a:deck) hm.put(a,hm.getOrDefault(a,0)+1);
        int g=0;
        for(int v:hm.values()) g=gcd(g,v);
        return g>=2;
    }
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
