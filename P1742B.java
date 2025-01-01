import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1742B {
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
            boolean b=false;
            for(i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            if(a.length==1) 
            {
                System.out.println("YES");
                continue;
            }
            for(i=0;i<n-1;i++)  if(a[i]-a[i+1]==0) b=true;
            if(b) System.out.println("NO");
            else System.out.println("YES");
        }
        s.close();
    }
}
