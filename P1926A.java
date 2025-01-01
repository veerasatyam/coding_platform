import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1926A {
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
            String a = s.next();
            int A=0,B=0;
            for(char c : a.toCharArray())
            {
                if(c=='A') A++;
                else B++;
            }
            if(A>B) System.out.println("A");
            else System.out.println("B");
        }
        s.close();
    }
}
