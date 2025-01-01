import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1360B {
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
            for (int i = 0; i < n; i++)  a[i] = s.nextInt();
            Arrays.sort(a);
            int min = Math.abs(a[0] - a[1]);
            for (int i = 0; i < n - 1; i++) {
                int diff = Math.abs(a[i] - a[i + 1]);
                if (min > diff)  min = diff;
            }

            System.out.println(min);
        }
        s.close();
    }
}
