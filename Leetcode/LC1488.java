// Brute Force
class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        if (helper(0, rains, new HashSet<>(), ans))  return ans;
        return new int[0];
    }

    boolean helper(int day, int[] rains, Set<Integer> full, int[] ans) {
        if (day == rains.length) return true;
        if (rains[day] > 0) {
            int lake = rains[day];
            if (full.contains(lake)) return false;
            full.add(lake);
            ans[day] = -1;
            boolean ok = helper(day + 1, rains, full, ans);
            full.remove(lake);
            return ok;
        } else {
            if (full.isEmpty()) {
                ans[day] = 1;
                return helper(day + 1, rains, full, ans);
            }
            for (int lake : new HashSet<>(full)) {
                ans[day] = lake;
                full.remove(lake);
                if (helper(day + 1, rains, full, ans)) return true;
                full.add(lake);
            }
            return false;
        }
    }
}



//optimal solution using Hashmap + Treeset or ordered set

class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> lakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] ans = new int[rains.length];
        for(int i=0;i<rains.length;i++){
             int lake = rains[i];
             if(lake==0){
                dryDays.add(i);
                ans[i] = 1; 
             }else{
                ans[i]=-1;
                if(lakes.containsKey(lake)){
                  int lastRainDay = lakes.get(lake);
                  Integer dryIndex = find(dryDays,lastRainDay);
                  if (dryIndex == null) return new int[0];
                  ans[dryIndex] = lake;
                  dryDays.remove(dryIndex);
                }
             }
             lakes.put(lake,i);
        }
        return ans;
    }
   private Integer find(TreeSet<Integer> dryDays,int lastRainDay){
    for(Integer a : dryDays) if(lastRainDay<a) return a;
    return null;
    }
}