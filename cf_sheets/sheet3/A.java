import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
           
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            sum += a[i]; 
        }
        System.out.println(Math.abs(sum));
        s.close();
    }
}
