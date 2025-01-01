import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1358A {
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
                int n = s.nextInt();
                int m = s.nextInt();
                int lanterns = (n * m + 1) / 2;
                System.out.println(lanterns);
    }
    s.close();
}
}
