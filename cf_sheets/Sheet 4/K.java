import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            String str1 = s.next();
            String str2 = s.next();
            String result = "";
            int l1 = str1.length(), l2 = str2.length();
            int i = 0, j = 0;
            while (i < l1 || j < l2) {
                if (i < l1) {
                    result += str1.charAt(i);
                    i++;
                }
                if (j < l2) {
                    result += str2.charAt(j);
                    j++;
                }
            }
            System.out.println(result);
        }
        s.close();
    }
}
