import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1399B {
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
            int[] b = new int[n];
            for (int i = 0; i < n; i++)  a[i] = s.nextInt();
            for (int i = 0; i < n; i++)   b[i] = s.nextInt();
            int min_candy = Integer.MAX_VALUE;
            int min_orange = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min_candy = Math.min(min_candy, a[i]);
                min_orange = Math.min(min_orange, b[i]);
            }
            long moves = 0;
            for (int i = 0; i < n; i++) {
                int diff_candy = a[i] - min_candy;
                int diff_orange = b[i] - min_orange;
                int common = Math.min(diff_candy, diff_orange);
                moves += common;
                diff_candy =diff_candy - common;
                diff_orange =diff_orange - common;
                moves += diff_candy + diff_orange;
            }
            System.out.println(moves);
        }
        s.close();
    }
}
