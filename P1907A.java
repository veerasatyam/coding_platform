import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P1907A{
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
        String pos = s.next();
        HashSet<String> moves = new HashSet<>();
        int i;
        for(i=1;i<=8;i++) 
        {
            String a = String.valueOf(i);
            String x = pos.charAt(0) + a;
            moves.add(x);
        }
        for(i=97;i<=104;i++)
        {
                char asciiChar = (char)i;
                String x = asciiChar + "" + pos.charAt(1);
                moves.add(x);
        }
           moves.remove(pos);
           for(String x : moves)
           {
            System.out.println(x);
           }
        }
        s.close();
    }
}