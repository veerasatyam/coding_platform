import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P702A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int n = s.nextInt();
        int[] a = new int[n];
        int max_len = 0, curr_len = 0;

        for (int i = 0; i < n; i++)  a[i] = s.nextInt();
        for (int i = 0; i < n - 1; i++) {
            if (a[i] < a[i + 1]) {
                curr_len++;
                max_len = Math.max(curr_len, max_len);
            } else {
                curr_len = 0;
            }
        }

        max_len = Math.max(curr_len, max_len);
        System.out.println(max_len + 1);
    }
}
