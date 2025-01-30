import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int n = s.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++)  a[i] = s.nextInt();
        boolean b = true; 
        for (int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - i - 1]) {
                b = false;
                break; 
            }
        }
        if (b) System.out.println("YES");
         else System.out.println("NO");
        s.close();
    }
}
