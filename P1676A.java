import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1676A {
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
            String str = s.nextLine();
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 6; i++) {
                int k = Character.getNumericValue(str.charAt(i));
                if (i < 3) sum1 += k;
                else  sum2 += k;
            }

            if (sum1 == sum2) System.out.println("YES");
            else System.out.println("NO");
        }

        s.close();
    }
}
