import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1996A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int animals = 0;
            if (n % 4 == 0) 
                animals = n / 4;
            else {
                animals = n / 4 + 1;
            }
            System.out.println(animals);
        }
    }
}
