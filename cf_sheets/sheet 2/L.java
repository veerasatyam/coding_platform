import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int GCD = 1;
        for(int i = 1; i <= Math.min(A, B); i++) if(A % i == 0 && B % i == 0) GCD = i; 
        System.out.println(GCD); 
        s.close();
    }
}
