import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int greatest = 0; 
        
        for (int i = 0; i < N; i++) {
            int element = s.nextInt();
            if (element > greatest) {
                greatest = element; 
            }
        }
        
        System.out.println(greatest);
        
        s.close(); 
    } 
}
