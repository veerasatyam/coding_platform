
import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long N = s.nextLong();
        long X=N;
        long digit;
        long sum=0;
        while(N!=0)
        {
           digit=N%10;
           sum=sum*10+digit;
           N=N/10; 
        }
        System.out.println(sum);
    if(X==sum)
    {
        System.out.println("YES");
    }
    else{
        System.out.println("NO");
    }
    }
}
