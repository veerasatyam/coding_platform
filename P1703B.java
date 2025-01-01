import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P1703B {
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
            int n = s.nextInt();
            String str = s.next();
            HashSet<Character> St_set = new HashSet<>();
            for(char c : str.toCharArray()) St_set.add(c);
            int total = St_set.size()*2 + (n-St_set.size());
            System.out.println(total);
        }
    }
}
