class Solution{
    public List<List<String>> wordSquares(String[] words){
        String[] sWords=words;
        List<List<String>> ans=new ArrayList<>();
        int n=sWords.length;
        for(int i=0;i<n;i++)
            for(int j=0; j<n;j++){
                if(i==j||sWords[i].charAt(0)!=sWords[j].charAt(0))continue;
                for(int k=0;k<n;k++){
                    if(k==i||k==j||sWords[i].charAt(3)!=sWords[k].charAt(0))continue;
                    for(int l=0;l<n;l++){
                        if(l==i||l==j||l==k)continue;
                    if(sWords[l].charAt(0)== sWords[j].charAt(3) && sWords[l].charAt(3)== sWords[k].charAt(3))                            ans.add(Arrays.asList(sWords[i],sWords[j],sWords[k],sWords[l]));
                    }
                }
            }
        ans.sort((a,b)->{
            for(int x= 0;x<4;x++){
                int c=a.get(x).compareTo(b.get(x));
                if(c !=0)return c;
            }
            return 0;
        });
        return ans;
    }
}
©leetcode