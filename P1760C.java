import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1760C {
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
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            int[] b = Arrays.copyOf(a, a.length);
            Arrays.sort(b);
            for(int i=0;i<n;i++)
            {
              if(a[i] != b[n-1])
              {
                int max = b[n-1];
                a[i] = a[i]-max;
              }
              else{
                int max = b[n-2];
                a[i] = a[i]-max;
              }
            }
            for(int i=0;i<n;i++) System.out.print(a[i]+" ");
            System.out.println();
        }
        s.close();
    }
}
