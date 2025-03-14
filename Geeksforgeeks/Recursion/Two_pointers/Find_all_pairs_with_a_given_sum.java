
// class Pair  {
//     long first, second;
//     public pair(long first, long second)
//     {
//         this.first = first;
//         this.second = second;
//     }
// }

import java.util.Arrays;

class Solution {
    public pair[] allPairs(int target, int arr1[], int arr2[]) {
        List<Pair> resultList = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1=0,p2=arr2.length;
        while (p1<arr1.length) {
            int sum = arr1[p1]+arr2[p2];
            if(sum==target)
            {
                resultList.add(new Pair(Math.min(arr1[p1], arr2[p2]), Math.max(arr1[p1], arr2[p2])));
                p1++;
                p2--;
            }else if(sum>target)
            {
                p2--;
            }
            else
            {
                p1++;
            }
        }
        return resultList.toArray(new Pair[0]);
    }
}