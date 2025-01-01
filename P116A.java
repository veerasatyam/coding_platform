import java.util.Scanner;

public class P116A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N_stops=s.nextInt();
        int Tramp_Capacity=0;
        int p_inside=0;
        for(int i=0;i<N_stops;i++)
        {
            int a =s.nextInt();
            int b=s.nextInt();
            p_inside=p_inside-a;
            p_inside=p_inside+b;
            if(p_inside>Tramp_Capacity)
            {
                Tramp_Capacity=p_inside;
            }
        }
   System.out.println(Tramp_Capacity);
        
    }
    
}
