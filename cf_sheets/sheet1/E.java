import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        float radius = s.nextFloat();
        final double PI = 3.141592653;
        double area = PI * radius * radius;
        System.out.println(String.format("%.9f", area));
        s.close();
    }
}
