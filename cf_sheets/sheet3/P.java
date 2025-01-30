import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P {

    public static boolean isEvenArray(int[] a) {
        for (int num : a) if (num % 2 != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int n = s.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            if (a[i] % 2 != 0) {
                System.out.println(0);
                s.close();
                return;
            }
        }
        
        int opp = 0;
        while (isEvenArray(a)) {
            for (int i = 0; i < a.length; i++) {
                a[i] /= 2;
            }
            opp++;
        }
        
        System.out.println(opp);
        s.close();
    }
}
