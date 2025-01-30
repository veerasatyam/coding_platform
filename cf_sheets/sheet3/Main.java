import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        HashSet<Integer> set = new HashSet<>();

    
        for (int i = 0; i < N; i++)  set.add(s.nextInt()); 
        for (int i = 0; i < Q; i++) {
            int X = s.nextInt();
            if (set.contains(X)) {
                System.out.println("found");
            } else {
                System.out.println("not found");
            }
        }
        s.close();
    }
}
