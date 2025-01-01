import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2038N{
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
            int x = Character.getNumericValue(a.charAt(0));
            int y = Character.getNumericValue(a.charAt(2));
            if(x==y) System.out.println(x+"="+y);
            else if(x>y) System.out.println(x+">"+y);
            else System.out.println(x+"<"+y);
        }
        s.close();
    }
}