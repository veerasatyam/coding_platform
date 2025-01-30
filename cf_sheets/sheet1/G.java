import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long N = s.nextLong();
        long sum = N * (N + 1) / 2;
        System.out.println(sum);
        s.close();
    }
}
