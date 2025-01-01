import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1829B {
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
            for (int i = 0; i < n; i++) a[i] = s.nextInt();
            int max_len = 0;
            int current_len = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    current_len++;
                    max_len = Math.max(max_len, current_len);
                } else current_len = 0;
            }
            System.out.println(max_len);
        }
        s.close();
    }
}
