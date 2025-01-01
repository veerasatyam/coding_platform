import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1702A{
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
            long m = s.nextLong();
            long roundNumber = 1;
            while (roundNumber <= m) {
                roundNumber *= 10;
            }
            roundNumber /= 10;
            long d = m - roundNumber;
            System.out.println(d);
        }
        s.close();
    }
}