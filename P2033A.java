import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2033A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
           s = new Scanner(System.in);
        }
        int t =s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            if(n%2==0) System.out.println("Sakurako");
            else System.out.println("Kosuke");
        }
        s.close();
    }
}
