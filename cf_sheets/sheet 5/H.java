import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class H {
    void printchar(int n,char ch)
    {
     for(int i=0;i<n;i++) System.out.print(ch+" ");
    }
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) 
        {
          s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            char ch = s.next().charAt(0);
            H h = new H();
            h.printchar(n,ch);
            System.out.println();
        }
        s.close();
    }
}
