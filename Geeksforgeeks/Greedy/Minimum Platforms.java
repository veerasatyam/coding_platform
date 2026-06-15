class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int result = 0;
        for(int i = 0;i < n-1;i++){
            int count = 0;
            for(int j = i+1;j < n;j++){
                if((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) count++;
            }
            result = Math.max(count,result);
        }
    }
}

// better solution
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 1;
        int result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                result = Math.max(result, count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return result;
    }
}