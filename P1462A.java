import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1462A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            int i;
            for(i=0;i<n;i++) a[i]=s.nextInt();
            int right = n - 1, left = 0;
            for (i = 0; i < n; i++) {
                if (i % 2 == 0) {
                   System.out.print(a[left]+ " ");
                    left++;
                } else {
                    System.out.print(a[right]+" ");
                    right--;
                }
            }
            System.out.println();
        }
        
        s.close();
    }
}
