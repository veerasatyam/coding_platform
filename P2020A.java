import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2020A {
     public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-->0)
        {   int operarions = 0;
            int n = s.nextInt();
            int k = s.nextInt();
            if(k==1) 
            {
                System.out.println(n);
                 continue;
            }
            while(n!=0)
            {
               operarions = operarions + n%k;
               n=n/k; 
            }
            System.out.println(operarions);
        }
        s.close();
    }
}
