import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1873A{
    public static void main(String[] args) {
        Scanner s = null;
        try {
           s = new Scanner(new File("input.txt")); 
        } catch (FileNotFoundException e) {
            s =  new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            String word =s.next();
            if(word.charAt(0)=='a'||word.charAt(1)=='b'||word.charAt(2)=='c') System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}