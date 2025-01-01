import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1791C {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            String str = s.next();
            int start = 0, end = n - 1;
            while (start < end && str.charAt(start) != str.charAt(end)) {
                start++;
                end--;
            }
            System.out.println(end - start + 1);
        }
        s.close();
    }
}
