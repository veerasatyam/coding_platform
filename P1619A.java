import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1619A {
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
            String str = s.next();
            if(str.length()%2 != 0) System.out.println("NO");
            else 
            {
               String a = str.substring(0,str.length()/2);
               String b = str.substring(str.length()/2,str.length());
               if(a.equals(b)) System.out.println("YES");
               else System.out.println("NO");
            }
        }
        s.close();
    }
}
