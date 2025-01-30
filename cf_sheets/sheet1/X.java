import java.util.Scanner;

public class X
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        long L1 = s.nextLong();
        long R1 = s.nextLong();
        long L2 = s.nextLong();
        long R2 = s.nextLong();
        long start =L2>L1?L2:L1;
        long end=R2>R1?R1:R2;
        if(start<=end)
        {
            System.out.println(start+" "+end);
        }
        else{
            System.out.println(-1);
        }
     s.close();

    }
}