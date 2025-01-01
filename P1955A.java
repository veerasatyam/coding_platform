import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1955A {
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
            int a = s.nextInt();
            int b = s.nextInt();
            int total_amount;
            if(2*a > b){
                if(n%2==0)  total_amount = (n/2)*b;
               else total_amount = (n/2)*b + a;
                System.out.println(total_amount);
            }
            else System.out.println(a*n);
        }
        s.close();
    }
}
