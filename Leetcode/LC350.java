class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int a : nums1) hm.put(a,hm.getOrDefault(a,0)+1);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int a : nums2){
            if(hm.containsKey(a)){
                arr.add(a);
                hm.put(a,hm.getOrDefault(a,0)-1);
                if(hm.get(a)==0) hm.remove(a);
            }
        }
        int[] res = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}