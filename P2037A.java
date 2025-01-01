import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P2037A {
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
            int i,j,score=0;
            for(i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            for(i=0;i<n-1;i++)
            {
                if(a[i]==a[i+1])
                {
                    score++;
                    i += 1;
                }
            }
            System.out.println(score);
        }
        s.close();
    }
}
