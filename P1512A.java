import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1512A {
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
            int uniqueIndex = -1;
            if (a[0] == a[1]) {
                for (int i = 2; i < n; i++) {
                    if (a[i] != a[0]) {
                        uniqueIndex = i + 1;
                        break;
                    }
                }
            } else  uniqueIndex = (a[0] == a[2]) ? 2 : 1;
            System.out.println(uniqueIndex);
        }
        s.close();
    }
}
