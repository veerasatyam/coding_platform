import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// not submitted 
public class P1374A {
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
            int x=s.nextInt();
            int y=s.nextInt();
            int n=s.nextInt();
            int k;
            for(int i=n;i>=0;i--)
            {
                if(i % x==y)
                {
                    k=i;
                    System.out.println(k);
                    break;
                }
            }
            
        }
        s.close();
    }
}
