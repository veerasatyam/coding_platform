import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P749A {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n = s.nextInt();
        if(n%2==0) 
        {   
            System.out.println(n/2);
            for(int i=0;i<n/2;i++) System.out.print("2 ");
        }
        else{
            System.out.println(n/2);
            for(int i=0;i<(n/2)-1;i++) System.out.print("2 ");
            System.out.print("3 ");
        }
        s.close();
    }
}
