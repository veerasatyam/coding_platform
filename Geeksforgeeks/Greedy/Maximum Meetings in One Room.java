import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxMeetings(int[] s, int[] f) {
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0;i < s.length;i++)meetings.add(new int[]{s[i], f[i], i + 1});
        Collections.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int index = meeting[2];
            if (start > lastEnd) {
                result.add(index);
                lastEnd = end;
            }
        }
        Collections.sort(result);
        return result;
    }
}



// using disjoint sets

import java.util.*;

class Disjoint {
    int[] parent;

    Disjoint(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // path compression
    }

    void union(int u, int v) {
        parent[u] = v;
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