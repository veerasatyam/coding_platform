import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1675A {
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
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int remainingDogs = Math.max(0, x - a);
            int remainingCats = Math.max(0, y - b);
            if (remainingDogs + remainingCats <= c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
