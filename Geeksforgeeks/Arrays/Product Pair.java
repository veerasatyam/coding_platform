class Solution {
    public boolean isProduct(int[] arr, long target) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }
        for (int num : arr) {
            if (num == 0){
                if (target == 0 && freq.get(0L) > 1) {
                    return true;
                }
                continue;
            }
            if (target % num == 0) {
                long need = target / num;
                if (freq.containsKey(need)){
                    if (need == num) {
                        if (freq.get(need) > 1) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}