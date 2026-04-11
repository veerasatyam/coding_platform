class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        int[] smallest = new int[n];
        int[] greatest = new int[n];
        Arrays.fill(smallest,-1);
        Arrays.fill(greatest,-1);
        int minIndex = 0;
        for(int i = 1;i<n;i++){
            if(arr[i] > arr[minIndex]){
                smallest[i] = minIndex;
            }else
            minIndex = arr[i] < arr[minIndex] ? i : minIndex;
        }
        int maxIndex = n-1;
        for(int i = n-2;i>=0;i--){
            if(arr[i] < arr[maxIndex]){
                greatest[i] = maxIndex;
            }
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        for(int i = 1;i<n-1;i++){
            if(smallest[i] != -1 && greatest[i] !=-1){
                ArrayList<Integer> res = new ArrayList<>();
                res.add(arr[smallest[i]]);
                res.add(arr[i]);
                res.add(arr[greatest[i]]);
                return res;
            }
        }
        return new ArrayList<>();
    }
}



// without extra Space
class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int prevFirst = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            int x = arr[i];
            if(x <= first){
                first = x;
            }else if(x <= second){
                second = x;
                prevFirst = first;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prevFirst);
                list.add(second);
                list.add(x);
                return list;
            }
        }
        return new ArrayList<>();
    }
}