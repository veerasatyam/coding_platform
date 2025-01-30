import java.util.Scanner;

public class V {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int number=1;
        for(int i=1;i<=N;i++)
        {
            for(int j=0;j<4;j++)
            {
             if(number%4==0) 
             {
                System.out.print("PUM");
                number++;
                continue;
             }
            System.out.print(number+" ");
            number++;
            }
            System.out.println();
        }
        s.close();
    }
}
