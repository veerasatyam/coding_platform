import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// don't know what is the errror 
public class O {
    public static void main(String[] args)
    {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        
        int N = s.nextInt(); 
        String S = s.next();  
        char[] charArray = S.toCharArray();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (charArray[j] > charArray[j + 1]) {
                    char temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                }
            }
        }
        System.out.println(new String(charArray));
        s.close();
    }
}
