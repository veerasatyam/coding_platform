import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P265A {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String sequence = s.next();
        String instructions = s.next();
        char[] a = sequence.toCharArray();
        int pointer=0;
        for(char c : instructions.toCharArray())
        {
          if(c==a[pointer])
          {
            pointer++;
          }
        }
        System.out.println(pointer+1);
        s.close();
    }
   
}
