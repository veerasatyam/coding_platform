import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1579A {
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
            String str = s.next();
            int a =0,b=0,c=0;
            for(char x : str.toCharArray())
            {
                if(x=='A') a++;
                else if (x=='B') b++;
                else c++;
            }
            int x = b-a-c;
            if(x==0) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}
