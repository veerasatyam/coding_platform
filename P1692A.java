import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1692A {
     public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt")); 
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t=s.nextInt();
        while(t-->0)
        {
            int[] participants = new int[4];
            int i,count=0;
            for(i=0;i<4;i++) participants[i]=s.nextInt();
            for(i=1;i<4;i++) if(participants[0]<participants[i]) count++;
            System.out.println(count);
        }
        s.close();
    }
}
