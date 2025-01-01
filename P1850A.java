import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1850A {
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
           int a=s.nextInt();
           int b=s.nextInt();
           int c=s.nextInt();
           if(a+b>=10 || a+c>=10 || b+c>=10) System.out.println("YES");
           else System.out.println("NO");

        }
        s.close();
    }
}
