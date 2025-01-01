import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1097A {
    public static void main(String[] args) {
          Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String tc = s.next();
        String[] hcs = new String[5];
        int i;
        boolean yes = false;
        for(i=0;i<5;i++)
        {
          hcs[i]=s.next();
          if(hcs[i].charAt(0)==tc.charAt(0) || hcs[i].charAt(1)==tc.charAt(1) ) yes = true;
        }
        if(yes) System.out.println("YES");
        else System.out.println("NO");
        s.close();
    }
}
