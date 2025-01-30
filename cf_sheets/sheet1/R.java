import java.util.Scanner;

public class R {

    public static void main(String[] args) 
    {
        
        final int Days_year = 365;
        final int Days_months = 30;
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int years = N / Days_year;
        int rDays = N % Days_year;
        int months = rDays / Days_months;
        rDays = rDays % Days_months;
        int days = rDays;
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(days + " days");
        s.close();
    }
}
