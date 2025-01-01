import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1660A {
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
            int a = s.nextInt();
            int b = s.nextInt();
            if(a==0) System.out.println(1);
            else 
            {
                int x = a + b*2+1;
                System.out.println(x);
            }
        }
        s.close();
    }
}
