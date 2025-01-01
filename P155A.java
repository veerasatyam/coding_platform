import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P155A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s=new Scanner(System.in);
        }
        int n=s.nextInt();
        int i;
        int[] a = new int[n];
        for(i=0;i<n;i++) a[i]=s.nextInt();
        int amazingCount = 0;
        int best = a[0];
        int worst = a[0];

        for (i = 1; i < n; i++) {
            if (a[i] > best) {
                amazingCount++;
                best=a[i];
            } else if (a[i] < worst) {
                amazingCount++; 
                worst= a[i];
            }
        }
        System.out.println(amazingCount);
        s.close();
    }
}
