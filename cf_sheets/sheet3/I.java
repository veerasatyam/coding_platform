import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class I {
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
            int val = Integer.MAX_VALUE; 
            int sum;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum = a[i] + a[j] + (j - i);  
                    val = Math.min(val, sum); 
                }
            }

            System.out.println(val);  
        }
    }
}
