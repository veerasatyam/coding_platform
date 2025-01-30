import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String sentence = s.next();
        String a="";
        for(char c :sentence.toCharArray())
        {
            if(Character.isLetter(c))
            {
               if(Character.isUpperCase(c)) a += Character.toLowerCase(c);
               else a += Character.toUpperCase(c);
            }
            else a += " ";
        }
        System.out.println(a);
        s.close();
    }
}
