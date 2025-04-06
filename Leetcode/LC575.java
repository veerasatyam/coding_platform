class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x:candyType){
            hs.add(x);
        }
        int n=candyType.length;
        int canEat=n/2;
        return Math.min(canEat, hs.size());
    }
}