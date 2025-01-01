import java.util.Scanner;
//submitted
public class P546A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    
        int k = s.nextInt(); 
        long n = s.nextLong(); 
        int w = s.nextInt(); 
        long totalCost = (long) k * w * (w + 1) / 2;
        
        
        long borrowAmount = totalCost - n;
        System.out.println(Math.max(borrowAmount, 0));
        s.close();
    }
}
