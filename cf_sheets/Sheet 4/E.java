import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E {
public static void main(String[] args) {
     Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String a = s.next();
        int sum =0;
        for(char c : a.toCharArray()) sum += Character.getNumericValue(c);
        System.out.println(sum);
        s.close();
}
}
