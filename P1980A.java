import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// enka cheyalee question malli chaduvuuu
public class P1980A {
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
            int n=s.nextInt();
            int m = s.nextInt();

        }
    }
}
