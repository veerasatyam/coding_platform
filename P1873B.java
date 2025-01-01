import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1873B {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int[] a = new int[n];
            int i;
            int product=1;
            for(i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            a[0]=a[0]+1;
            for(i=0;i<n;i++) product *= a[i];
            System.out.println(product);
        }
        s.close();
    }
}
