import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/// not submitted 
public class P1343B {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t=s.nextInt();
        while(t-->0)
        {
            int n=s.nextInt();
            if(n%4 != 0) System.out.println("NO");
            else
            {
                System.out.println("YES");
                int[] a = new int[n];
                int i,sum_odd=0,sum_even=0;
                for(i=0;i<n/2;i++) a[i]=2*(i+1);
                for(i=n/2;i<n;i++) a[i]=2*i+1;
                a[n-1]=2*n/2 +(n/2-1);
                for(int num : a) System.out.print(num+" ");
                System.out.println();

            }
        }
        s.close();
    }
}
