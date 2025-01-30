import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int A = s.nextInt();
        int B = s.nextInt();
        String str = s.next();
        if (str.length() == A + B + 1 && str.charAt(A) == '-') {
            boolean a =true;
            for(int i=0;i<str.length();i++)
            {
                if(!Character.isDigit(str.charAt(i)) && i!=A)
                {
                    a=false;
                    break;
                }
            }
            if(a) System.out.println("Yes");
            else  System.out.println("No");
            
        } else {
            System.out.println("No");
        }
        
        s.close();
    }
}
