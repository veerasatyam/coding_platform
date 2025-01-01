import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1473A {
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
            int d = s.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            int min1 = a[0],min2=a[1];
            if(min1+min2 <= d) System.out.println("YES");
            else{
                boolean possible = true;
                for (int i = 0; i < n; i++) {
                    if (a[i] > d) {
                        possible = false;
                        break;
                    }
                }
                System.out.println(possible ? "YES" : "NO");
            }
            
        }
        s.close();
    }
}
