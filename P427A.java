
import java.util.Scanner;

public class P427A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int man_power=0;
        int crimes=0;
        for(int i=0;i<n;i++)
        {
            int x=s.nextInt();
            if(x==-1){
                if(man_power>0) man_power--;
                else crimes++;
            }
            else man_power=man_power+x;
        }
        System.out.println(crimes);
        s.close();
        
    }
}
