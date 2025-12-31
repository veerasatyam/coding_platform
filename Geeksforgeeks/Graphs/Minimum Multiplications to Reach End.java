// tricky question to understand that this question is related to dijkstras algorithm

class Solution {
    class Pair{
        int step,value;
        Pair(int step,int value){
            this.step = step;
            this.value = value;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        int[] distance = new int[100000];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,start));
        distance[start] = 0;
        while(!q.isEmpty()){
            Pair x = q.poll();
            int s = x.step;
            int val = x.value;
            if(val == end) return s;
            for(int i=0;i<n;i++){
                int a = (val * arr[i]) % 100000;
                if(distance[a] > s + 1){
                    distance[a] = s + 1;
                    q.add(new Pair(s+1,a));
                }
            }
        }
        return -1;
    }
}