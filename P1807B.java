import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1807B {
    public static void main(String[] args) {
        Scanner s = null;
        try{            s = new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e){
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int[] a = new int[n];
            int i,even=0,odd=0;
            for(i=0;i<n;i++) {
                a[i]=s.nextInt();
                if(a[i]%2==0) even += a[i];
                else odd += a[i];
            }
            if(even > odd) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}
