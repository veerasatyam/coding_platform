
import java.util.Scanner;
//submitted
public class P734A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        String Exp=s.next();
        int A=0;
        int D=0;
        for (int i=0;i<N;i++)
        {
            char x=Exp.charAt(i);
            if(x=='A')
            {
                A++;
            }
            else{
                D++;
            }
        }
        if(A>D)
        {
            System.out.println("Anton");
        }
        else
        {
            System.out.println("Danik");
        }
        s.close();
  }
}
