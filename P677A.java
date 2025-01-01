
import java.util.Scanner;
//submitted

public class P677A {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int H = s.nextInt();
        int width=0;
        for(int i =0;i<n;i++)
        {
            int x=s.nextInt();
            if(x>H)
            {
                width++;
            }
            width++;
        }
    System.out.println(width);
    s.close();
        }
}
