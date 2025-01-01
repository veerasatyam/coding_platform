import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2009B {
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
            String[] input = new String[n];
            for (int i = 0; i < n; i++)  input[i] = s.next();
            int[] a = new int[n];
            int b=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<4;j++)
                {
                    if(input[i].charAt(j)=='#'){
                        a[b]=j+1;
                        b++;
                    }
                }
            }
           for(int i=n-1;i>=0;i--) System.out.print(a[i]+" ");
           System.out.println();
        }
        s.close();
    }
}
