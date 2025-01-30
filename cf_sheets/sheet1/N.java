import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char X = s.next().charAt(0);
        if (Character.isLowerCase(X))
         {
            char UC = Character.toUpperCase(X);
            System.out.println(UC);
         } 
        else if (Character.isUpperCase(X))
         {
            char LC = Character.toLowerCase(X);
            System.out.println(LC);
         }
        s.close();
    }
}
