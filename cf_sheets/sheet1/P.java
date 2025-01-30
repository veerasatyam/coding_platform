import java.util.Scanner;

public class P {

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int X=s.nextInt();
        String numbeString=Integer.toString(X);
        char FC=numbeString.charAt(0);
        int FD=Character.getNumericValue(FC);
        if(FD % 2==0)
        {
            System.out.println("EVEN");
        }
        else{
            System.out.println("ODD");
        }
        s.close();

    }
}
