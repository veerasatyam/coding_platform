import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P432A {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int k=s.nextInt();
        ArrayList<Integer> p = new ArrayList<>();
        int i;
        for(i=0;i<n;i++)
        {
            int x=s.nextInt();
            if(x+k<=5) p.add(x);
        } 
        int teams=p.size()/3;
        System.out.println(teams);

    }
}
