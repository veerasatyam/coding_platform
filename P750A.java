import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P750A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int n = s.nextInt();
        int k = s.nextInt(); 
        int availableTime = 240 - k;
        int i = 1;
        int count = 0; 
        while (i <= n && availableTime >= 5 * i) {
            availableTime -= 5 * i; 
            count++; 
            i++;
        }

        System.out.println(count); 
        s.close();
    }
}
