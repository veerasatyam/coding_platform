import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P1367A {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t =s.nextInt();
        while(t-->0)
        {
            String code = s.next();
            ArrayList<Character> result = new ArrayList<>();
           
            result.add(code.charAt(0));
            for (int j = 1; j < code.length(); j += 2) result.add(code.charAt(j));
            for (Character ch : result) System.out.print(ch);
            System.out.println();
        }
        
    }
}
