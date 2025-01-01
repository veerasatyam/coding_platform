import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1850B {
    public static void main(String args[])
    {
        Scanner s = null;
         try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int winnerIndex = -1;
            int quality = -1;
            for (int j = 1; j <= n; j++) {
                int a = s.nextInt();
                int b = s.nextInt();
                if (a <= 10) {
                    if (b > quality) {
                        quality = b;
                        winnerIndex = j;
                    }
                }
            }
            System.out.println(winnerIndex);
        }
        s.close();
    }
}
