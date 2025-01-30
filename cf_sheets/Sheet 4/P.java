import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String input = s.nextLine(); 
        input = input.replaceAll("[!.,?]", "");
        String[] words = input.split("\\s+");
        System.out.println(words.length);
        s.close();
    }
}
