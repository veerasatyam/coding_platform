import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1915A {
     public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t =s.nextInt();
        while(t-->0){
           int a=s.nextInt();
           int b=s.nextInt();
           int c=s.nextInt();
           if(a-b==0) System.out.println(c);
           else if(a-c==0) System.out.println(b);
           else System.out.println(a);
        }
        s.close();
    }
}
