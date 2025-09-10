class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> lang_person = new ArrayList<>();
        for (int[] a : languages) {
            HashSet<Integer> set = new HashSet<>();
            for (int x : a) set.add(x);
            lang_person.add(set);
        }

        HashSet<Integer> need_to_learn_people = new HashSet<>();
        
        for (int[] a : friendships) {
            Set<Integer> u = lang_person.get(a[0] - 1);
            Set<Integer> v = lang_person.get(a[1] - 1); 
            boolean communicate = false;
            for (int x : u) {
                if (v.contains(x)) {
                    communicate = true;
                    break;
                }
            }
            if (!communicate) {
                need_to_learn_people.add(a[0] - 1);
                need_to_learn_people.add(a[1] - 1);
            }
        }

        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int person : need_to_learn_people) {
                if (!lang_person.get(person).contains(i)) count++;
            }
            min = Math.min(count, min);
        }
        
        return min;
    }
}
