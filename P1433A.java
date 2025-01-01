import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1433A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            int x = s.nextInt();
            StringBuilder str = new StringBuilder();
            int j = 0;
            boolean found = false;

            for (int i = 1; i <= 9; i++) {
                int sum = 0;
                for (j = 0; j < 4; j++) { 
                    sum = sum * 10 + i; 
                    str.append(sum); 
                    if (sum == x) {
                        found = true; 
                        break; 
                    }
                }
                if (found) break;
            }
            System.out.println(str.length()); 
        }
        s.close();
    }
}
