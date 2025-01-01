import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
// find the error in the code 
public class P1971B {
    public static void main(String args[]) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            String str = s.nextLine();
            if (str.length() == 1) {
                System.out.println("NO");
                continue;
            }
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (sortedString.equals(str)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(sortedString);
            }
        }
        s.close();
    }
}
