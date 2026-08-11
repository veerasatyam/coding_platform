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

