// bruteForce

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < mat.length;i++){
            for(int j = 0; j< mat[0].length; j++){
                ans.add(mat[i][j]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

// using mergeSort
import java.util.*;

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int k = mat.length;
        if (k == 0) return new ArrayList<>();
        return merge(mat, 0, k - 1);
    }
    private ArrayList<Integer> merge(int[][] mat, int l, int r) {
        if (l == r) {
            ArrayList<Integer> base = new ArrayList<>();
            for (int num : mat[l]) {
                base.add(num);
            }
            return base;
        }   
        int mid = l + (r - l) / 2;
        ArrayList<Integer> left = merge(mat, l, mid); 
        ArrayList<Integer> right = merge(mat, mid + 1, r);
        return concat(left, right);
    }
    private ArrayList<Integer> concat(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0, j = 0;
        int n1 = a.size();
        int n2 = b.size();
        ArrayList<Integer> result = new ArrayList<>(n1 + n2);   
        while (i < n1 && j < n2) {
            if (a.get(i) >= b.get(j)) {
                result.add(b.get(j++));
            } else {
                result.add(a.get(i++));
            }
        }
        while (i < n1) result.add(a.get(i++));
        while (j < n2) result.add(b.get(j++));
        
        return result;
    }
}

// using Heaps
import java.util.*;

class Solution {
    class Element {
        int val;
        int row;
        int idx;

        Element(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < mat.length; i++) {
            if (mat[i].length > 0) {
                minHeap.add(new Element(mat[i][0], i, 0));
            }
        }
        while (!minHeap.isEmpty()) {
            Element curr = minHeap.poll();
            result.add(curr.val);
            if (curr.idx + 1 < mat[curr.row].length) {
                minHeap.add(new Element(mat[curr.row][curr.idx + 1], curr.row, curr.idx + 1));
            }
        }
        return result;
    }
}