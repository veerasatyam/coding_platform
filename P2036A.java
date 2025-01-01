import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2036A {
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
            boolean f=false;
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            for(int i=0;i<n-1;i++)
            {
                int x = Math.abs(a[i]-a[i+1]);
                if(!(x==7 || x==5)) 
                {
                    f=true;
                    break;
                }
            }
            if(f) System.out.println("NO");
            else  System.out.println("YES");
        }
    }
}
