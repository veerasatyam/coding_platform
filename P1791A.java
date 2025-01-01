import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1791A {
     public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String word = "codeforces";
         Set<Character> set_elements = new HashSet<>();
        for (char ch : word.toCharArray()) set_elements.add(ch);
        int t=s.nextInt();
        while(t-->0)
        {
            String input = s.next();
            char c = input.charAt(0);
            if(set_elements.contains(c)) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}
