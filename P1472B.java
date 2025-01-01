import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/// think and do it again 
public class P1472B {
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
            int one=0,two=0;
            for(int i=0;i<n;i++)
            {
               a[i]=s.nextInt();
               if(a[i]==1) one++;
               else two++;
            }
            int sum=one+2*two;
            if(one%2==0 && two%2==0 && sum%2==0) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}
