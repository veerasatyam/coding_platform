import java.util.Scanner;

public class L {
    
    public static int[] concatenateArrays(int[] a, int[] b, int n) {
        int[] c = new int[2 * n];
        System.arraycopy(b, 0, c, 0, n);  // Copy elements of array B
        System.arraycopy(a, 0, c, n, n);  // Copy elements of array A
        return c;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = s.nextInt();
        }
        
        int[] c = concatenateArrays(a, b, n);
        
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        
        s.close();
    }
}
