import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        double result = (double) A / B;
        long floorValue = (long) Math.floor(result);
        long ceilValue = (long) Math.ceil(result);
        long roundValue = Math.round(result);
        System.out.println("floor " + A + " / " + B + " = " + floorValue);
        System.out.println("ceil " + A + " / " + B + " = " + ceilValue);
        System.out.println("round " + A + " / " + B + " = " + roundValue);
        s.close();
    }
}
