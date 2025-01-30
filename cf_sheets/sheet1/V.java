import java.util.Scanner;

public class V {

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        char S = s.next().charAt(0);
        int B = s.nextInt();
        boolean result = false;
        switch (S) {
            case '<':
                result = A < B;
                break;
            case '>':
                result = A > B;
                break;
            case '=':
                result = A == B;
                break;
        }
        if (result) {
            System.out.println("Right");
        } else {
            System.out.println("Wrong");
        }
        
        s.close();
    }
}
