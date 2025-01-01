import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1669B {
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
            boolean found= false;
            int count=0;
            for(i=0;i<n-1;i++){
                if(a[i]==a[i+1]) count++;
                else count=0;
                if(count==2)
                {
                    found = true;
                    break;
                }
            }
            if(found) System.out.println(a[i]);
            else System.out.println(-1);
        }
    }
}
