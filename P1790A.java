import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1790A {
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
            String input = s.next();
            final String a = "314159265358979323846264338327";
            int count=0,i=0;
            for(char c : input.toCharArray())
            {
                if(a.charAt(i)==c) 
                {
                    count++;
                    i++;
                }
                else {
                    break;
                }
            }
            System.out.println(count);
        }
        s.close();
    }
}
