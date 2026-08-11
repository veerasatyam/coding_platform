class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
       List<int[]> list = new ArrayList<>();
       int n = deadline.length;
       for(int i = 0; i< deadline.length; i++){
        list.add(new int[]{deadline[i],profit[i]});
       }
       list.sort((a,b) -> b[1] - a[1]);
       int[] slot = new int[n];
       int x = 0;
       int count = 0;
       for(int i = 0; i < n; i++){
        int start = Math.min(n,list.get(i)[0]) - 1;
        for(int j = start; j >= 0; j--){
            if(slot[j] == 0) {
                slot[j] = 1;
                count++;
                x += list.get(i)[1];
                break;
            }
        }
       }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(x);
        return result;
    }
}




class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0;i < n;i++)jobs.add(new int[]{deadline[i], profit[i]});
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0;i < jobs.size();i++) {
            int[] job = jobs.get(i);
            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } 
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }
       
        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }

        return ans;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<int[]> jobs = new ArrayList<>();
        int maxDeadline = 0;
        for (int i = 0;i < n;i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        Collections.sort(jobs, (a, b) -> Integer.compare(b[0], a[0]));
        Disjoint ds = new Disjoint(maxDeadline);
        int countJobs = 0;
        int totalProfit = 0;
        for (int[] job : jobs) {
            int p = job[0];
            int d = job[1];
            int availableSlot = ds.find(d);
            if (availableSlot > 0) {
                countJobs++;
                totalProfit += p;
                ds.union(availableSlot, ds.find(availableSlot - 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countJobs);
        ans.add(totalProfit);
        return ans;
    }
}