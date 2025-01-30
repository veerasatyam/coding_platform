import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class M {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        String str = s.next();
        final String word = "hello";
        if (str.length() < word.length()) {
            System.out.println("NO");
            return;
        }
        boolean[] b = new boolean[word.length()];
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == word.charAt(i)) {
                b[i] = true;
                i++;
                if (i == word.length()) break;
            }
        }
        boolean result = areAllTrue(b);
        if (result) System.out.println("YES");
        else  System.out.println("NO");
    }
    
    public static boolean areAllTrue(boolean[] arr) {
        for (boolean value : arr)  if (!value) return false;
        return true;
    }
}
