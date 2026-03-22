class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < 4; i++) {
            if (areMatricesEqual(mat, target)) {
                return true;
            }
            rotateMatrix(mat);
        }
        return false;
    }
    private boolean areMatricesEqual(int[][] mat1,int[][] mat2){
        int n = mat1.length;
        for(int i = 0;i<n;i++){
            boolean x = Arrays.equals(mat1[i], mat2[i]);
            if(!x) return false;
        }
        return true;
    }
    private void rotateMatrix(int[][] mat){
        int n = mat.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            reverseArray(mat[i]);
        }
    }
    private void reverseArray(int[] arr){
        int left = 0, right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}