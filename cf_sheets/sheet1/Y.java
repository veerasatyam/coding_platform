import java.math.BigInteger;
import java.util.Scanner;

public class Y 
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        BigInteger A = s.nextBigInteger();
        BigInteger B = s.nextBigInteger();
        BigInteger C = s.nextBigInteger();
        BigInteger D = s.nextBigInteger();

        BigInteger result = A.multiply(B).multiply(C).multiply(D);
        BigInteger Fresult = result.mod(BigInteger.valueOf(100));
        
        // Format the output to always show two digits
        System.out.printf("%02d%n", Fresult);
        
        s.close();
    }
}
