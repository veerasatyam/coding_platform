import java.util.Scanner;

public class F 
{
   public static void main(String[] args)
   {
    Scanner s = new Scanner(System.in);
    long N = s.nextLong();
    long M = s.nextLong();
     M=M %10;
     N=N %10;
    System.out.println(M+N);
    s.close();
   }
}