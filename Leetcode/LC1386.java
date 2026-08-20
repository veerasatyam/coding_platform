class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map =new HashMap<>();
        for(int[] r : reservedSeats){
            map.putIfAbsent(r[0],new HashSet<>());
            map.get(r[0]).add(r[1]);
        }
        int count = (n - map.size()) * 2;
        for(int key : map.keySet()){
            boolean first = true;
            boolean mid = true;
            boolean last = true;
            Set<Integer> set = map.get(key);
            for(int i = 2; i <= 5; i++){
                if(set.contains(i)){
                    first = false;
                    break;
                } 
            }
            for(int i = 4; i <= 7; i++){
                if(set.contains(i)){
                    mid = false;
                    break;
                } 
            }
            for(int i = 6; i <= 9; i++){
                if(set.contains(i)){
                    last = false;
                    break;
                } 
            }
            if(first && last) count += 2;
            else if(first || last || mid) count++;
        }
        return count;
    }
}