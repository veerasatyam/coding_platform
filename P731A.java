import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P731A {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        String str = s.next();
        char curr ='a';
        int moves=0;
        for(char c : str.toCharArray())
        {
            int clockwise = Math.abs(c - curr);
            int counterClockwise = 26 - clockwise;
            moves += Math.min(clockwise, counterClockwise);
            curr=c;
        }
        System.out.println(moves);
    }
}
