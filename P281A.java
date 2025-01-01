import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P281A {
    public static void main(String[] args)
    {
        Scanner s= null;
        try{
            s=new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
             s= new Scanner(System.in);
        }
        String word = s.next();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(word);
        s.close();
    }
}
