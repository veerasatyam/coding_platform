import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P141A {
    public static void main(String[] args)
    {
        Scanner s = null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
            s = new Scanner(System.in);
        }
        String guest=s.next();
        String host =s.next();
        String shuffle=s.next();
        char[] guestArray = guest.toCharArray();
        char[] hostArray = host.toCharArray();
        char[] shuffleArray = shuffle.toCharArray();
        Arrays.sort(shuffleArray);
        char[] combinedArray = new char[guestArray.length + hostArray.length];
        System.arraycopy(guestArray, 0, combinedArray, 0, guestArray.length);
        System.arraycopy(hostArray, 0, combinedArray, guestArray.length, hostArray.length);
        Arrays.sort(combinedArray);
        if(Arrays.equals(shuffleArray, combinedArray))  System.out.println("YES");
        else System.out.println("NO");

    }
}
