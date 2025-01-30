import java.util.Scanner;

public class U {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String N = s.nextLine();

        if (N.contains(".")) {
            double num = Double.parseDouble(N);
            int iPart = (int) num;
            double dPart = num - iPart;

            if (dPart == 0)
            {
                System.out.println("int " + iPart);
            } 
            else 
            {
                System.out.printf("float %d %.3f\n", iPart, dPart);
            }
        } 
        else 
        {
            int integerValue = Integer.parseInt(N);
            System.out.println("int " + integerValue);
        }

        s.close();
    }
}
