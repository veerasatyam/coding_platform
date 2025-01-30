import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        
        for (int i = 1; i <= 12; i++) 
        {
            System.out.println(N + " * " + i + " = " + (N * i));
        }
        
        s.close();
    }
}
