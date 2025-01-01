import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1950A {
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
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if(a<b && b<c) System.out.println("STAIR");
            else if( a<b && b>c) System.out.println("PEAK");
            else System.out.println("NONE");
        }
        s.close();
    } 
}
