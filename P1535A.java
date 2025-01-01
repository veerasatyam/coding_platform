import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1535A {
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
            int[] a = new int[4];
            for(int i = 0;i<4;i++) a[i]=s.nextInt();
            int pair1=Math.max(a[0], a[1]);
            int min_pair1=Math.min(a[0],a[1]);
            int pair2=Math.max(a[2], a[3]);
            int min_pair2=Math.min(a[2],a[3]);
            if(min_pair1 < pair2 && min_pair2 < pair1) System.out.println("YES");
            else System.out.println("NO");

        }
        s.close();
    }
}
