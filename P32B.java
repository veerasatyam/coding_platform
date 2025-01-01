import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class P32B {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        String code = s.next();
        StringBuilder result = new StringBuilder();
        int i;
        for(i=0;i<code.length();i++)
        {
          if(code.charAt(i)=='.') result.append('0');
          else if(code.charAt(i)=='-')
          {
            if(i+1<code.length() && code.charAt(i+1)=='.') 
            {
                result.append('1');
                i=i+1;
            }
            else if(i+1<code.length() && code.charAt(i+1)=='-')
            {
                result.append('2');
                i=i+1;
            }

          }
        }
        System.out.println(result.toString());
        s.close();
    }
}
