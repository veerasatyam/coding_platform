import java.util.Scanner;

public class M {

    boolean isLucky(int number) {
        String nums = Integer.toString(number);
        for (char ch : nums.toCharArray()) if (ch != '4' && ch != '7')  return false;     
        return true;
    }

    public static void main(String[] args) {
        M obj1 = new M();
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        boolean Lucky = false;
        for (int i = A; i <= B; i++) {
            if (obj1.isLucky(i)) {
                System.out.print(i + " ");
                Lucky = true;
            }
        }
        if (!Lucky) System.out.println("-1");
        
        s.close();
    }
}
