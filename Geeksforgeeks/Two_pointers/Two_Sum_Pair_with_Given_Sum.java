class Solution {
    boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        int p1 = 0,p2=arr.length-1;
        while(p1<p2)
        {
            if(arr[p1]+arr[p2]==target) return true;
            else if(arr[p1]+arr[p2]>target) p2--;
            else p1++;
        }
        return false;
    }
}