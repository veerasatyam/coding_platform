import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1426A {
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
            int x = s.nextInt();
            int floor_n=1;
            if(n<=2) 
            {
                System.out.println(floor_n);
                continue;
            }
            else{
               n = n-2;
               floor_n = n/x +1;
               if( (float)n/x > n/x) floor_n +=1;
               System.out.println(floor_n);
            }
        }
        s.close();
    }
}
