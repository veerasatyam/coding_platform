import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1901A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int x = s.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            int max_gap = a[0];
            for(int i = 1; i < n; i++) {
                max_gap = Math.max(max_gap, a[i] - a[i-1]);
            }
            max_gap = Math.max(max_gap, 2*(x - a[n-1]));

            System.out.println(max_gap);
        }
    }
}
