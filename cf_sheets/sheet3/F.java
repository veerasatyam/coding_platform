import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s=new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int i;
        int[] a = new int[n];
        for(i=0;i<n;i++) a[i]=s.nextInt();
        for(i=n-1;i>=0;i--) System.out.print(a[i]+" ");
    }
}
