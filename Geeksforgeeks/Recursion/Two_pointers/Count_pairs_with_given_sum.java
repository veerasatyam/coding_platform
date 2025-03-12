class Solution {

    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            if (arr[left] + arr[right] == target) {
                if (arr[left] != arr[right]) {
                    int leftCount = 1;
                    int rightCount = 1;

                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    count += leftCount * rightCount;
                    left++;
                    right--;
                } else {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2;
                    break;
                }
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}