import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1722A {

    public static String isValidTimurName(String s) {
        String correctName = "Timur";
        if (s.length() != 5) {
            return "NO";
        }
        
        char[] sArray = s.toCharArray();
        char[] correctArray = correctName.toCharArray();
        
        Arrays.sort(sArray);
        Arrays.sort(correctArray);
        
        if (Arrays.equals(sArray, correctArray)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        s.nextLine();

        while (t-- > 0) {
            int n = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            System.out.println(isValidTimurName(str));
        }
        
        s.close();
    }
}
