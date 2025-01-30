import java.util.Scanner;

public class L {
    public static void main(String[] args) 
    {
       
        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
        String[] p1 = firstLine.split(" ");
        String secondName1 = p1[1];
        String secondLine = s.nextLine();
        String[] p2 = secondLine.split(" ");
        String secondName2 = p2[1];
        if (secondName1.equals(secondName2)) {
            System.out.println("ARE Brothers");
        } else {
            System.out.println("NOT");
        }
        s.close();
    }
}
