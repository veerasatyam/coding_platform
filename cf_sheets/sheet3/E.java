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
        int small = Integer.MAX_VALUE;
        int small_index = -1;
        for (int i = 0; i < n; i++) {
            int current = s.nextInt();
            if (current < small) {
                small = current; 
                small_index = i + 1; 
            }
        } 
        System.out.println(small + " " + small_index);
        s.close();
    }
}
