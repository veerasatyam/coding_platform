import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
    }
}
