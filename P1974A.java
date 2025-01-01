import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// don't know the error
public class P1974A {
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
            int x = s.nextInt();
            int y = s.nextInt();
            int screen=0;
            while(y>0 || x>0)
            {
              y = y-3;
              x = x - 3;
              screen++;
            }
            System.out.println(screen);
        }
    }
}
