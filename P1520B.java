import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// not gonna work because it time limt exceeds 2 sec
public class P1520B
{
    public static boolean isEqual(int number) {
        String numberStr = Integer.toString(number);
        char firstDigit = numberStr.charAt(0);
        for (int i = 1; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) != firstDigit) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = null;
        try{
            s = new Scanner(new File("input.txt"));
        }
        catch(FileNotFoundException e)
        {
            s = new Scanner(System.in);
        }
        int t=s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int count=0;
            for(int i=1;i<=n;i++) if(isEqual(i)) count++;
            System.out.println(count);
        }
        s.close();
    }
}