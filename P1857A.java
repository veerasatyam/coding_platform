import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1857A{
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
            int sum=0;
            for(int i=0;i<n;i++) 
            {
                a[i]=s.nextInt();
                sum += a[i];
            }
            if(sum %2==0) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}