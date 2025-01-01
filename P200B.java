import java.util.Scanner;
//submitted
public class P200B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            int p = s.nextInt();
            sum += p; 
        }
        double averagePercentage = sum / N;
        System.out.println(averagePercentage);

        s.close();
    }
}
