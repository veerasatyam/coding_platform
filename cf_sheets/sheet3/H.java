import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class H {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) System.out.print(a[i] + " "); 
    }
}
