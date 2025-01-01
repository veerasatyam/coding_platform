import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2008A {
    public static void main(String[] args)
    {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            if(b%2==0 && a%2==0) System.out.println("YES");
            else{
                b=b%2;
                int x =Math.abs(b*2 - a);
                if(x==0) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        s.close();
    }
}
// / int x = Math.abs(b*2-a);
            // if(b==0)
            // {
            //     if(a%2==0) System.out.println("YES");
            //     else System.out.println("NO");
            // }
            // else{
            //     if((x/2)%2==0) System.out.println("YES");
            //     else System.out.println("NO");
            // }