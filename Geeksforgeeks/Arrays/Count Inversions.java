class Solution {
    static int inversionCount(int arr[]) {
       return mergeSort(arr,0,arr.length - 1);
    }
    private static int mergeSort(int[] arr,int low,int high){
        if(low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = 0;
        count = count + mergeSort(arr,low,mid);
        count = count + mergeSort(arr,mid + 1,high);
        count = count + merge(arr,low,mid,high);
        return count;
    }
    private static int merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while(i <= mid && j<= high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                count += (mid + 1 - i);
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= high){
            temp[k++] = arr[j++];
        }
        for(i = low;i <= high;i++){
            arr[i] = temp[i - low];
        }
        return count;
    }
}