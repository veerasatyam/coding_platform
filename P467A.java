import java.util.Scanner;
//submitted
public class P467A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int available_rooms=0;
        for(int i =0;i<N;i++)
        {
            int p=s.nextInt();
            int q=s.nextInt();
            if(q-p>=2)
            {
                available_rooms++;
            }
        }
        System.out.println(available_rooms);
        s.close();
    }
}
