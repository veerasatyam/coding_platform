import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        String input = s.nextLine();
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            result.append(reversedWord).append(" ");
        }

        System.out.println(result.toString().trim());
        s.close();
    }
}
