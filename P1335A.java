import java.util.Scanner;

public class P1335A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T=s.nextInt();

        while(T-->0)
        {
            long total_ways=0;
            long number=s.nextLong();
            if(number%2==0) total_ways=(number/2)-1;
            else total_ways=number/2;
            System.out.println(total_ways);
        }
    }
}
