class Solution {
    public String findOrder(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegre = new int[26];
        boolean[] exist = new boolean[26];
        for(int i=0;i<26;i++) adj.add(new ArrayList<>());
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exist[ch - 'a'] = true;
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int len = Math.min(w1.length(),w2.length());
            int j=0;
            while(j<len && w1.charAt(j)==w2.charAt(j)) j++;
            if(j<len){
                int u = w1.charAt(j) - 'a';
                int v = w2.charAt(j) - 'a';
                adj.get(u).add(v);
                indegre[v]++;
            }else if(w1.length() > w2.length()) return "";
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<26;i++){
            if(exist[i] && indegre[i]==0) q.add(i);
        }
        String result = "";
        while(!q.isEmpty()){
            int u = q.poll();
            result += (char)(u+'a');
            for(int v : adj.get(u)){
                indegre[v]--;
                if(indegre[v]==0) q.add(v);
            }
        }
        for(int i=0;i<26;i++){
            if(exist[i] && indegre[i] != 0){
                return "";
            }
        }
        return result;
    }
}