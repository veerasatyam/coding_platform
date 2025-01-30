import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++)
        {
            int num=s.nextInt();
            int count=0;
            while(num!=0)
            {
                int remainder;
                remainder=num%2;
                if(remainder==1) count++;
                num /=2;
            }
            int sum=0;
            for(int j=count;j>=0;j--) sum=sum+(int)Math.pow(2,j-1);
         
            System.out.println(sum);

        }
        s.close();
    }
}
