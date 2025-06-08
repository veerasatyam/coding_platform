class GfG {
    int preIndex = 0;

    void printPostOrder(int in[], int pre[]) {
        printPostOrderUtil(in, pre, 0, in.length - 1);
    }

    void printPostOrderUtil(int in[], int pre[], int inStart, int inEnd) {
        if (inStart > inEnd) return;

        int rootVal = pre[preIndex++];
        
        int rootIndex = search(in, inStart, inEnd, rootVal);

        printPostOrderUtil(in, pre, inStart, rootIndex - 1);  
        printPostOrderUtil(in, pre, rootIndex + 1, inEnd);  

        System.out.print(rootVal + " ");    
    }

    int search(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
}
