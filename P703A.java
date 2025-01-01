import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P703A {
      public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int No_of_rounds=s.nextInt();
        int i,m=0,c=0;
        for(i=0;i<No_of_rounds;i++)
        {
            int mScore = s.nextInt();
            int cScore = s.nextInt();
            
            if (mScore > cScore) m++;
            else if (mScore < cScore) c++;
        }
        if(m>c) System.out.println("Mishka");
        else if(m<c) System.out.println("Chris");
        else System.out.println("Friendship is magic!^^");
        s.close();
    }
}
