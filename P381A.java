import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P381A {
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
        int Sreeja_count = 0;
        int Dima_count = 0;
        int L = 0;
        int R = n - 1;
        boolean isSreejaTurn = true;
        while (L <= R) {
            if (a[L] > a[R]) {
                if (isSreejaTurn) Sreeja_count += a[L];
                 else Dima_count += a[L];
                L++;
            } else {
                if (isSreejaTurn)  Sreeja_count += a[R];
                 else Dima_count += a[R];
                R--;
            }
            isSreejaTurn = !isSreejaTurn; 
        }
        
        System.out.println(Sreeja_count + " " + Dima_count);
        s.close();
    }
}
