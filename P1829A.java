import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1829A {
     public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        final String a = "codeforces";
        while(t-->0)
        {
            String b = s.next();
            int differ=0;
            for(int i=0;i<10;i++) if(!(a.charAt(i)==b.charAt(i))) differ++;
            System.out.println(differ);
        }
        s.close();
    }
}
