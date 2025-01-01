import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1791B {
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
            String str = s.next();
            int i=0,j=0;
            boolean found=false;
            for(char c:str.toCharArray())
            {
                if(c=='U') j++;
                else if(c=='D') j--;
                else if(c=='L') i--;
                else i++;
                if(i==1 && j==1) found=true;
            }
            if(found) System.out.println("YES");
            else System.out.println("NO");
        }
        s.close();
    }
}
