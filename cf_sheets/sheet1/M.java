import java.util.Scanner;

public class M{
    public static void main(String[] args)
     {
        Scanner s = new Scanner(System.in);
        char X = s.next().charAt(0);
        if (X >= '0' && X <= '9') {
            System.out.println("IS DIGIT");
        } 
        else if ((X >= 'A' && X <= 'Z') || (X >= 'a' && X <= 'z'))
         {
            System.out.println("ALPHA");
            if (X >= 'A' && X <= 'Z') 
            {
                System.out.println("IS CAPITAL");
            }
            else if (X >= 'a' && X <= 'z') 
            {
                System.out.println("IS SMALL");
            }
        } 
        s.close();
    }
}
