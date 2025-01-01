import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1676B {
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
            for(i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            int eaten_candies=0;
            for(i=1;i<n;i++) eaten_candies += a[i]-a[0];
            System.out.println(eaten_candies);
        }
        s.close();
    }
}
