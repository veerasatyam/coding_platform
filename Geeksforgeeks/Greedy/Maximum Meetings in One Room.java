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