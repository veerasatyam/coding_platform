import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int n = s.nextInt();
        int sum = 0, count = 0;
        
        while (sum + count + 1 <= n) {
            count++;
            sum += count;
        }
        
        System.out.println(count);
        s.close();
    }
}
