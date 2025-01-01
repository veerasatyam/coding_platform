import java.util.Arrays;
import java.util.Scanner;
public class P723A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int[] houses = {a, b, c};
        Arrays.sort(houses);
        int median = houses[1];
        int Min_Distance = Math.abs(a - median) + Math.abs(b - median) + Math.abs(c - median);
        System.out.println(Min_Distance);
        s.close();
    }
}
