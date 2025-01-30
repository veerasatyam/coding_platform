import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Y {
    public static int summation(int l, int r, int[] a) {
        int sum = 0;
        for (int i = l; i <= r; i++) sum += a[i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int N = s.nextInt();
        int Q = s.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = s.nextInt();
        while (Q-- > 0) {
            int L = s.nextInt(); 
            int R = s.nextInt();
            int result = summation(L - 1, R - 1, a);
            System.out.println(result);
        }
        
        s.close();
    }
}
