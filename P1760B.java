import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P1760B {
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
            char[] a = str.toCharArray();
            Arrays.sort(a);
            int ascii_value = (int)a[n-1];
            System.out.println(ascii_value-96);
        }
        s.close();
   } 
}
