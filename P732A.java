import java.util.Scanner;

public class P732A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();              
        int denominationCoin = s.nextInt();
        int i = 1;
        while (true) {
            if (k * i % 10 == 0 || k * i % 10 == denominationCoin) break;
            i++;
        }
        System.out.println(i);
    }
}
