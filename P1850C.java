import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1850C {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int t = s.nextInt();
        while (t-- > 0) {
           StringBuilder result = new StringBuilder();
           for (int i = 0; i < 8; i++) {
               String str = s.next();
               for(char c : str.toCharArray()) if(Character.isLetter(c)) result.append(c);
           }
           System.out.println(result);
        }
        s.close();
    }
}